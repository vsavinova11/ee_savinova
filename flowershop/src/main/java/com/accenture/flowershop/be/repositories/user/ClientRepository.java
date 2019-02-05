package com.accenture.flowershop.be.repositories.user;

import com.accenture.flowershop.be.entity.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    void deleteClientById(long id);
}
