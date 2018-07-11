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
import com.mikehawek.business.dao.ItemManagement.ItemDao;
import com.mikehawek.business.dto.ItemManagement.ItemDto;

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
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage msg = (ObjectMessage) message;
                ItemDto item = (ItemDto) msg.getObject();
                LoggingSupport.logTimeToConsole("ItemManagementReceiver: Received message with item " + item.getBarCode());
                if (item != null && item.isEdited()) {
                    dao.edit(item);
                } else if (item != null) {
                    dao.save(item);
                }
                message.acknowledge();
            } else if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                String id = msg.getText();
                if (id != null)
                    dao.deleteItem(id);
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
