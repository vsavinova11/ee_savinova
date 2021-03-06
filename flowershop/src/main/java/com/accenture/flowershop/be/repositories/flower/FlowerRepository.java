package com.accenture.flowershop.be.repositories.flower;

import com.accenture.flowershop.be.entity.flower.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Long>, JpaSpecificationExecutor<Flower> {
    Flower findByName(String flowerName);
    Flower findById(long id);
}
