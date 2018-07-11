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
import com.mikehawek.business.dto.ItemManagement.ItemDto;

@Stateless
public class ItemManagementProducer {
    @Resource(lookup = "jms/ItemManagementFactory")
    private ConnectionFactory connectionFactory;

    @Resource (lookup = "jms/ItemManagement")
    private Topic topic;

    public void sendAddOrUpdateItemMessage(ItemDto itemDto) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(topic);

            ObjectMessage message = session.createObjectMessage();

            message.setObject(itemDto);
            LoggingSupport.logTimeToConsole("ItemManagementProducer: Sending message with item " + itemDto.getBarCode());
            messageProducer.send(message);
            messageProducer.close();
            connection.close();

        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }


    public void sendDeleteItemMessage(String id) {
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
