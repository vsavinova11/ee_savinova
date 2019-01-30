package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.be.entity.PersistentEntity;
import com.accenture.flowershop.be.entity.user.Client;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "flowerOrder")
public class Order extends PersistentEntity {
    @OneToMany
    List<OrderItem> orderItems;
    @ManyToOne
    Client client;



}
