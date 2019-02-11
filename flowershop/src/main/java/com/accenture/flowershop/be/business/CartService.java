package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.order.OrderItem;

import java.util.List;

public interface CartService {
    List<OrderItem> addFlowerToCart (List<OrderItem> cart, long flowerId, int count);
    double getTotal(List<OrderItem> cart, int discount);
}
