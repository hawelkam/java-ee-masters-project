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

import com.mikehawek.business.dao.OrderManagement.OrderDao;
import com.mikehawek.business.dto.OrderManagement.OrderDto;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/OrderManagement"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/OrderManagement"),
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/OrderManagement"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
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
                if (order != null && order.isEdited()) {
                    dao.edit(order);
                } else if (order != null) {
                    dao.save(order);
                }
                message.acknowledge();
            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
}
