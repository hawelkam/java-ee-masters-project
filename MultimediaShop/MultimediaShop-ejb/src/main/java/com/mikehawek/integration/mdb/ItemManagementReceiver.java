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

import com.mikehawek.business.dao.ItemManagement.ItemDao;
import com.mikehawek.integration.entities.Item;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/ItemManagement"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/ItemManagement"),
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/ItemManagement"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class ItemManagementReceiver implements MessageListener {
    @Resource
    private MessageDrivenContext mdc;

    @Inject
    private ItemDao dao;

    public ItemManagementReceiver() {
    }

    @Override
    public void onMessage(Message message) {
        ObjectMessage msg = null;
        try {
            if (message instanceof ObjectMessage) {
                msg = (ObjectMessage) message;
                Item item = (Item) msg.getObject();
                if (item != null)
                    dao.save(item);
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
