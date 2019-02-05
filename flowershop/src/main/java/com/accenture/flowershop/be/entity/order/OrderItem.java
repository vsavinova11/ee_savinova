package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.be.entity.PersistentEntity;
import com.accenture.flowershop.be.entity.flower.Flower;


import javax.persistence.*;

@Entity
public class OrderItem extends PersistentEntity {
    @ManyToOne
    private Flower flower;
    private int count;
    private double price;
    OrderItem(){

    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
