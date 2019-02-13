package com.accenture.flowershop.be.business;
import com.accenture.flowershop.be.entity.flower.Flower;

import java.util.List;

public interface FlowerService {
    Flower findById(long id);
    Flower addFlower(Flower flower);
    List<Flower>listFlower();
    List<Flower>listFlowers(String name, Integer from, Integer to);
    void writeOffFlower(Flower flower, int count);
}
