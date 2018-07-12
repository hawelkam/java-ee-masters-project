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

import com.mikehawek.business.LoggingSupport;
import com.mikehawek.business.dto.UserManagement.UserDto;

@Stateless
public class UserManagementProducer {
    @Resource(lookup = "jms/UserManagementFactory")
    private ConnectionFactory connectionFactory;

    @Resource (lookup = "jms/UserManagement")
    private Topic topic;

    public void sendAddUserMessage(UserDto userDto) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(topic);

            ObjectMessage message = session.createObjectMessage();

            message.setObject(userDto);
            LoggingSupport.logTimeToConsole("UserManagementProducer: Sending message with user " + userDto.getLogin());
            messageProducer.send(message);
            messageProducer.close();
            connection.close();

        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}
