package com.accenture.flowershop.be.entity.flower;

import com.accenture.flowershop.be.entity.PersistentEntity;
import com.sun.istack.NotNull;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class Flower extends PersistentEntity {
    @Column(nullable = false, length = 64)
    private String name;
    private BigDecimal price;
    private int count;

    Flower(){
    }

    public BigDecimal getPrice() {
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
