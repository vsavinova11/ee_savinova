package com.accenture.flowershop.be.repositories.order;

import com.accenture.flowershop.be.entity.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
