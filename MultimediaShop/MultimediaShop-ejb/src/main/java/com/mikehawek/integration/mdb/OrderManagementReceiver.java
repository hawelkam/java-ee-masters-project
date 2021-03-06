package com.mikehawek.integration.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.mikehawek.business.LoggingSupport;
import com.mikehawek.business.dao.OrderManagement.OrderDao;
import com.mikehawek.business.dto.OrderManagement.OrderDto;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/OrderManagement1"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/OrderManagement"),
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/OrderManagement"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "EntityType = 'Order'")
})
public class OrderManagementReceiver implements MessageListener {
    @Resource
    private MessageDrivenContext mdc;

    @Inject
    private OrderDao dao;

    public OrderManagementReceiver() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage msg = (ObjectMessage) message;
                OrderDto order = (OrderDto) msg.getObject();
                LoggingSupport.logTimeToConsole("OrderManagementReceiver: Received message with order " + order.getId());
                if (order != null && order.isEdited()) {
                    dao.edit(order);
                } else if (order != null) {
                    dao.save(order);
                }
            } else if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                String id = msg.getText();
                if (id != null)
                    dao.cancelOrder(Integer.valueOf(id));
            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
}
