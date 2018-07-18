/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import com.mikehawek.business.dao.ItemManagement.ItemNameDao;
import com.mikehawek.business.dto.ItemManagement.ItemNameDto;

/**
 *
 * @author Hawek
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/FetchItemsMessage1"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/FetchItemsMessage"),
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/FetchItemsMessage"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "EntityType = 'ItemName'")
})
public class ItemNameManagementReceiver implements MessageListener {
    
    @Resource
    private MessageDrivenContext mdc;

    @Inject
    private ItemNameDao dao;
    
    public ItemNameManagementReceiver() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage msg = (ObjectMessage) message;
                ItemNameDto item = (ItemNameDto) msg.getObject();
                System.out.println("ItemNameManagementReceiver: Received message with itemName " + item.getProductCode());
                if (item != null && item.isEdited()) {
                    dao.edit(item);
                } else if (item != null) {
                    dao.save(item);
                }
            } else if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                String id = msg.getText();
                if (id != null)
                    dao.deleteItemName(id);
            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
}
