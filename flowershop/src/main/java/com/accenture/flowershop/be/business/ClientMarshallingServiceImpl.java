/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.user.Client;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Service;


@Service
public class ClientMarshallingServiceImpl implements ClientMarshallingService {

    @Autowired
    private Marshaller marshaller;

    @Value("${client.marshall.dir}")
    private String path;

    @PostConstruct
    public void init() {
        File parent = new File(path);
        if (!parent.exists()) {
            parent.mkdirs();
        }
    }

    @Override
    public void saveToFile(Client client) {
        File file = new File(path, client.getLogin() + ".xml");
        Result result = new StreamResult(file);
        try {
            marshaller.marshal(client, result);
        } catch (IOException | XmlMappingException ex) {
            throw new RuntimeException(ex);
        }
    }

}
