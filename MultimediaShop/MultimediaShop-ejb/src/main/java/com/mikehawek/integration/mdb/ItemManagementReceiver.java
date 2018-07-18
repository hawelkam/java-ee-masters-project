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
        @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/ItemManagement1"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/ItemManagement"),
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/ItemManagement"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "EntityType = 'Item'")
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
            } else if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                String id = msg.getText();
                if (id != null)
                    dao.deleteItem(id);
            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }

}
