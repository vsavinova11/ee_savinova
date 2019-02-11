package com.accenture.flowershop.be.business;
import com.accenture.flowershop.be.entity.order.ClientOrder;
import com.accenture.flowershop.be.entity.order.OrderItem;
import com.accenture.flowershop.be.entity.user.Client;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ClientOrderService {
    ClientOrder addClientOrder(Client client, List<OrderItem> cart, double total);
    List<ClientOrder> findClientOrders(Client client);
    ClientOrder findById(Long id);
    void orderPay(Long id);
    List<ClientOrder> findAllClientOrders();
    List<ClientOrder> findAllClientOrders(String column, Sort.Direction direction);
    void closeOrder(Long id);
}
