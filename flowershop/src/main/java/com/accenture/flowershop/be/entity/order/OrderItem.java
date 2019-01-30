package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.be.entity.PersistentEntity;
import com.accenture.flowershop.be.entity.flower.Flower;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderItem extends PersistentEntity {
    @OneToOne
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
        if (count<0 || count<flower.getCount()){
            this.count = 0;
        }
        else {
            this.count = count;
        }
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
