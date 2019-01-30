package com.accenture.flowershop.be.entity.flower;

import com.accenture.flowershop.be.entity.PersistentEntity;

import javax.persistence.Entity;

@Entity

public class Flower extends PersistentEntity {
    private String name;
    private double price;
    private int count;

    Flower(){
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setCount(int count) {
        this.count = count>0 ? count : 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price>0 ? price : 0;
    }
}
