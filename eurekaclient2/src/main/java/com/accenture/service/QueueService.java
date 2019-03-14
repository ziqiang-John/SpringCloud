package com.accenture.service;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class QueueService {
    public String requestQueue(String request){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://128.236.224.75:61616");
        Connection connection = null;
        String result = null;
        try{
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("promoteAct");
            MessageConsumer messageConsumer = session.createConsumer(destination);
            TextMessage textMessage = (TextMessage)messageConsumer.receive();
            result = textMessage.getText()+request;
            session.commit();
            session.close();
        }catch (JMSException jmsException){
            jmsException.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }catch (JMSException e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
