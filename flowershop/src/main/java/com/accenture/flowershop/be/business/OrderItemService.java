package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.order.OrderItem;

import java.util.List;

public interface OrderItemService {
    void addOrderItems(List<OrderItem> orderItems);
}
