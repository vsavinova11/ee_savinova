package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.OrderItem;
import java.math.BigDecimal;
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
        orderItem.setPrice(flower.getPrice().multiply(BigDecimal.valueOf(count)));
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
    public BigDecimal getTotal(List<OrderItem> cart, int discount) {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item:cart) {
            total=total.add(item.getPrice());
        }
        return total.subtract(total.divide(BigDecimal.valueOf(100l).multiply(BigDecimal.valueOf(discount))));
    }
}
