package com.accenture.flowershop.fe.dto;

import com.accenture.flowershop.be.entity.order.OrderItem;
import java.math.BigDecimal;

import java.util.List;

public class CartDto {
    private List<OrderItem> cart;
    private BigDecimal total;

    public List<OrderItem> getCart() {
        return cart;
    }

    public void setCart(List<OrderItem> cart) {
        this.cart = cart;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
