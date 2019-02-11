package com.accenture.flowershop.be.business;
import com.accenture.flowershop.be.entity.user.Client;
import com.accenture.flowershop.be.repositories.user.ClientRepository;
import com.accenture.flowershop.fe.dto.ClientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findByLogin(String login) {
        return clientRepository.findByLogin(login);
    }


    @Override
    public Client addClient(ClientInfo clientInfo) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Client client = clientRepository.findByLogin(clientInfo.getLogin());
        if (client == null){
            client = new Client();
            client.setLogin(clientInfo.getLogin());
            client.setPassword(passwordEncoder.encode(clientInfo.getPassword()));
            client.setAddress(clientInfo.getAddress());
            client.setPhone(clientInfo.getPhone());
            client.setFullName(clientInfo.getFullName());
            client.setDiscount(0);
            client.setBalance(new BigDecimal(2000));
            return clientRepository.saveAndFlush(client);
        }
        return null;
    }

    @Transactional
    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    @Transactional
    public void removeClient(long id) {
    }
}
