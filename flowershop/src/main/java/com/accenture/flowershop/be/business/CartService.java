package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.order.OrderItem;
import java.math.BigDecimal;

import java.util.List;

public interface CartService {
    List<OrderItem> addFlowerToCart (List<OrderItem> cart, long flowerId, int count);
    BigDecimal getTotal(List<OrderItem> cart, int discount);
}
