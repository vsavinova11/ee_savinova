package com.accenture.flowershop.be.repositories.order;

import com.accenture.flowershop.be.entity.order.ClientOrder;
import com.accenture.flowershop.be.entity.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {
    ClientOrder findByClient(Client client);
}