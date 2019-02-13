/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.flower.Flower;
import java.util.List;
import javax.jws.WebService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;



@WebService(endpointInterface = "com.accenture.flowershop.be.business.FlowerStockWebService")
@Service
@Transactional
public class FlowerStockWebServiceImpl implements FlowerStockWebService {

    @Autowired
    private FlowerService flowerService;

    @Override
    public void increaseFlowerStockSize(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("count is negative or zero");
        }
        List<Flower> flowers = flowerService.listFlower();
        for (Flower f : flowers) {
            f.setCount(f.getCount() + count);
        }

    }

}
