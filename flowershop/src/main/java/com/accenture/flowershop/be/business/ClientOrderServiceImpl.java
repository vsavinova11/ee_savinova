package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.order.ClientOrder;
import com.accenture.flowershop.be.repositories.order.ClientOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientOrderServiceImpl implements ClientOrderService {

    @Autowired
    private ClientOrderRepository clientOrderRepository;

    @Override
    public ClientOrder addClientOrder(ClientOrder clientOrder) {
        ClientOrder saveClientOrder = clientOrderRepository.saveAndFlush(clientOrder);
        return saveClientOrder;
    }
}
