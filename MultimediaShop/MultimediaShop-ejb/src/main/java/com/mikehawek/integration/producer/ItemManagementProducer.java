package com.mikehawek.integration.producer;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;

import com.mikehawek.business.ItemFactory;
import com.mikehawek.business.dto.ItemManagement.ItemDto;
import com.mikehawek.integration.entities.Item;

public class ItemManagementProducer {
    @Stateless
    public class AddItemProducer {
        @Resource(lookup = "jms/ItemManagementFactory")
        private ConnectionFactory connectionFactory;

        @Resource (lookup = "jms/ItemManagement")
        private Topic topic;

        public void sendAddItemMessage(ItemDto itemDto) {
            try {
                Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
                MessageProducer messageProducer = session.createProducer(topic);

                ObjectMessage message = session.createObjectMessage();
                Item item = ItemFactory.createItem(itemDto);

                message.setObject(item);
                messageProducer.send(message);
                messageProducer.close();
                connection.close();

            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }

}
