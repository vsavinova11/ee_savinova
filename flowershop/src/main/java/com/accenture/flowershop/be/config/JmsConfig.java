/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.flowershop.be.config;

import com.accenture.flowershop.be.business.ClientService;
import com.accenture.flowershop.fe.dto.DiscountRequest;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.NamingException;
import javax.xml.transform.stream.StreamSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jndi.JndiTemplate;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;


@Configuration
public class JmsConfig {

    @Bean
    public ConnectionFactory connectionFactory() throws NamingException {
        return new JndiTemplate().lookup("java:comp/env/jms/connectionFactory", ConnectionFactory.class);
    }

    @Bean
    public Queue inQueue() throws NamingException {
        return new JndiTemplate().lookup("java:comp/env/jms/inQueue", Queue.class);
    }

    @Bean
    public Queue outQueue() throws NamingException {
        return new JndiTemplate().lookup("java:comp/env/jms/outQueue", Queue.class);
    }
    
    @Bean
    public JmsTemplate jmsTemplate() throws NamingException
    {
        return new JmsTemplate(connectionFactory());
    }
    
    @Bean
    @Autowired
    public MessageListenerContainer containerFactory(Unmarshaller unmarshaller, ClientService clientService) throws NamingException
    {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setDestination(inQueue());
        container.setMessageListener((MessageListener) (Message msg) -> {
            try {
                if(!(msg instanceof TextMessage))
                    return;
                TextMessage textMessage = (TextMessage)msg;
                String body = textMessage.getText();
                DiscountRequest dr = (DiscountRequest)unmarshaller.unmarshal(new StreamSource(body));
                clientService.setDiscount(dr.getCustomerId(), dr.getNewDiscount());
            } catch (JMSException|IOException|XmlMappingException ex) {
                throw new RuntimeException(ex);
            }
        });
        return container;
    }
    
}
