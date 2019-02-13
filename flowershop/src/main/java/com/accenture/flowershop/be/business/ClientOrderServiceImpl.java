package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.order.ClientOrder;
import com.accenture.flowershop.be.entity.order.OrderItem;
import com.accenture.flowershop.be.entity.order.OrderStatus;
import com.accenture.flowershop.be.entity.user.Client;
import com.accenture.flowershop.be.repositories.order.ClientOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ClientOrderServiceImpl implements ClientOrderService {

    @Autowired
    private ClientOrderRepository clientOrderRepository;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private FlowerService flowerService;

    @Override
    public ClientOrder addClientOrder(Client client, List<OrderItem> cart, BigDecimal total) {
        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setClient(client);
        clientOrder.setOrderItems(cart);
        clientOrder.setCreationDate(new Date().toString());
        clientOrder.setStatus(OrderStatus.Created);
        clientOrder.setTotal(total);
        orderItemService.addOrderItems(clientOrder.getOrderItems());
        return clientOrderRepository.saveAndFlush(clientOrder);
    }

    @Override
    public List<ClientOrder> findClientOrders(Client client) {
        return clientOrderRepository.findByClient(client);
    }

    @Override
    public ClientOrder findById(Long id) {
        return clientOrderRepository.findById(id).orElse(null);
    }

    @Override
    public  synchronized void orderPay(Long id) {
        ClientOrder clientOrder = findById(id);
        if (clientOrder == null){
            throw new RuntimeException("Failed to pay. Order not found.");
        }
        Client client = clientOrder.getClient();
        BigDecimal clientOrderTotal = clientOrder.getTotal();
        if (clientOrderTotal.compareTo(client.getBalance()) > 0){
            throw new RuntimeException("Failed to pay. Insufficient funds.");
        }
        client.setBalance(client.getBalance().subtract(clientOrderTotal));
        clientOrder.setStatus(OrderStatus.Paid);

        for (OrderItem item: clientOrder.getOrderItems()) {
            flowerService.writeOffFlower(item.getFlower(), item.getCount());
        }

    }

    @Override
    public List<ClientOrder> findAllClientOrders() {
        return clientOrderRepository.findAll();
    }

    @Override
    public List<ClientOrder> findAllClientOrders(String column, Sort.Direction direction) {
        Sort sort = Sort.by(direction, column);
        return clientOrderRepository.findAll(sort);
    }

    @Override
    public void closeOrder(Long id) {
        ClientOrder clientOrder = findById(id);
        if (clientOrder == null) {
            throw new RuntimeException("Error close order");
        }
        Date closeDate = new Date();
        clientOrder.setClosingDate(closeDate.toString());
        clientOrder.setStatus(OrderStatus.Completed);

    }

}
