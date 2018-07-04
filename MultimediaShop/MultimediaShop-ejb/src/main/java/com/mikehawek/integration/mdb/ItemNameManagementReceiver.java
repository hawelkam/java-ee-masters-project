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
import com.mikehawek.integration.entities.itemnames.ItemName;

/**
 *
 * @author Hawek
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/FetchItemsMessage")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/FetchItemsMessage")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/FetchItemsMessage")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
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
                ItemName item = (ItemName) msg.getObject();
                if (item != null)
                    dao.save(item);
                message.acknowledge();
            } else if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                String id = msg.getText();
                if (id != null)
                    dao.deleteItemName(id);
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
