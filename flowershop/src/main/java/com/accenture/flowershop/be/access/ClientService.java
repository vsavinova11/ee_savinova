package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.user.Client;

import java.util.List;

public interface ClientService {
    Client addClient (Client client);
    List<Client> listClient();
    void removeClient(long id);
}
