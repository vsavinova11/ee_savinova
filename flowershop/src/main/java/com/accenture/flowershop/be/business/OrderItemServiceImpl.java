package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.order.OrderItem;
import com.accenture.flowershop.be.repositories.order.OrderItemRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public void addOrderItems(List<OrderItem> orderItems) {
        for (OrderItem orderItem: orderItems) {
            BigDecimal price = orderItem.getFlower().getPrice().multiply(BigDecimal.valueOf(orderItem.getCount()));
            orderItem.setPrice(price);
            orderItemRepository.saveAndFlush(orderItem);
        }
    }
}
