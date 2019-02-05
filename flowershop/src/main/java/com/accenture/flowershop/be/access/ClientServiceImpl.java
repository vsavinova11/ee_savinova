package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.user.Client;
import com.accenture.flowershop.be.repositories.user.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client addClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Transactional
    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    @Transactional
    public void removeClient(long id) {
        clientRepository.deleteClientById(id);
    }
}
