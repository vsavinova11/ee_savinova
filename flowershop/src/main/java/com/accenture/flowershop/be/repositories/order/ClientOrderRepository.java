package com.accenture.flowershop.be.repositories.order;

import com.accenture.flowershop.be.entity.order.ClientOrder;
import com.accenture.flowershop.be.entity.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {
    List<ClientOrder> findByClient(Client client);
}