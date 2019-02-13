/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.user.Client;
import java.io.IOException;
import java.io.StringWriter;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class JmsAdvice {

    @Autowired
    @Qualifier("outQueue")
    private Queue outQueue;

    @Autowired
    private Marshaller marshaller;

    @Autowired
    private JmsTemplate jmsTemplate;

    @AfterReturning(value = "execution(* com.accenture.flowershop.be.business.ClientService.addClient(..))", returning = "client")
    public void afterRegistration(Client client) throws JMSException, IOException, XmlMappingException {
        if (client != null) {
            jmsTemplate.send(outQueue, (session)
                    -> {
                try {
                    StringWriter sw = new StringWriter();
                    Result result = new StreamResult(sw);
                    marshaller.marshal(client, result);
                    return session.createTextMessage(sw.toString());
                } catch (IOException | XmlMappingException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }
}
