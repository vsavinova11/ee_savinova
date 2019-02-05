package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.repositories.flower.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FlowerServiceImpl implements FlowerService {
    @Autowired
    FlowerRepository flowerRepository;
    @Override
    public Flower addFlower(Flower flower) {
        return flowerRepository.saveAndFlush(flower);
    }
}
