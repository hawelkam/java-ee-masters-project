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

import com.mikehawek.business.LoggingSupport;
import com.mikehawek.business.dao.OrderManagement.OrderDao;
import com.mikehawek.business.dao.UserManagement.UserDao;
import com.mikehawek.business.dto.OrderManagement.OrderDto;
import com.mikehawek.business.dto.UserManagement.UserDto;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/UserManagement"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/UserManagement"),
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/UserManagement"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class UserManagementReceiver implements MessageListener {
    @Resource
    private MessageDrivenContext mdc;

    @Inject
    private UserDao dao;

    public UserManagementReceiver() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage msg = (ObjectMessage) message;
                UserDto user = (UserDto) msg.getObject();
                LoggingSupport.logTimeToConsole("OrderManagementReceiver: Received message with user " + user.getLogin());
                if (user != null) {
                    dao.save(user);
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
