package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    FlowerService flowerService;

    @Override
    public List<OrderItem> addFlowerToCart(List<OrderItem> cart, long flowerId, int count) {
        Flower flower = flowerService.findById(flowerId);
        OrderItem orderItem = new OrderItem();
        orderItem.setFlower(flower);
        orderItem.setCount(count);
        orderItem.setPrice(flower.getPrice()*count);
        OrderItem toDelete = null;
        for (OrderItem item: cart) {
            if (item.getFlower().getId() == flowerId){
                int newCount = item.getCount() + count;
                if (newCount>item.getFlower().getCount()){
                    throw new RuntimeException("Error add to cart");
                }
                else{
                    orderItem.setCount(count);
                    toDelete = item;
                }
            }
        }
        if(toDelete!=null)
        {
            cart.remove(toDelete);
        }
        cart.add(orderItem);
        return cart;
    }

    @Override
    public double getTotal(List<OrderItem> cart, int discount) {
        double total = 0.0;
        for (OrderItem item:cart) {
            total+=item.getPrice();
        }
        return total - total/100*discount;
    }
}
