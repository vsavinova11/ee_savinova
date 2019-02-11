package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.entity.order.OrderItem;

import java.util.List;

public class CartDto {
    private List<OrderItem> cart;
    private double total;

    public List<OrderItem> getCart() {
        return cart;
    }

    public void setCart(List<OrderItem> cart) {
        this.cart = cart;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
