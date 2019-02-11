package com.accenture.flowershop.be.business;
import com.accenture.flowershop.be.entity.user.Client;
import com.accenture.flowershop.fe.dto.ClientInfo;

import java.util.List;

public interface ClientService {
    Client addClient (ClientInfo clientInfo);
    Client findByLogin(String login);
    List<Client> listClient();
    void removeClient(long id);
}
