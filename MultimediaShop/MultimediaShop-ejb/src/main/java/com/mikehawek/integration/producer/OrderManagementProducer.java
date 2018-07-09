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

import com.mikehawek.business.dto.OrderManagement.OrderDto;

@Stateless
public class OrderManagementProducer {
    @Resource(lookup = "jms/OrderManagementFactory")
    private ConnectionFactory connectionFactory;

    @Resource (lookup = "jms/OrderManagement")
    private Topic topic;

    public void sendAddOrUpdateOrderMessage(OrderDto orderDto) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(topic);

            ObjectMessage message = session.createObjectMessage();

            message.setObject(orderDto);
            messageProducer.send(message);
            messageProducer.close();
            connection.close();

        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}
