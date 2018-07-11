package com.mikehawek.integration.producer;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import com.mikehawek.business.LoggingSupport;
import com.mikehawek.business.dto.ItemManagement.ItemNameDto;

@Stateless
public class ItemNameManagementProducer {
    @Resource(lookup = "jms/FetchItemsMessageFactory")
    private ConnectionFactory connectionFactory;

    @Resource (lookup = "jms/FetchItemsMessage")
    private Topic topic;

    public void sendAddOrUpdateItemNameMessage(ItemNameDto itemNameDto) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(topic);

            ObjectMessage message = session.createObjectMessage();

            message.setObject(itemNameDto);
            LoggingSupport.logTimeToConsole("ItemNameManagementProducer: Sending message with itemName " + itemNameDto.getProductCode());
            messageProducer.send(message);
            messageProducer.close();
            connection.close();

        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    public void sendDeleteItemNameMessage(String id) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(topic);

            TextMessage message = session.createTextMessage();

            message.setText(id);
            messageProducer.send(message);
            messageProducer.close();
            connection.close();

        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}
