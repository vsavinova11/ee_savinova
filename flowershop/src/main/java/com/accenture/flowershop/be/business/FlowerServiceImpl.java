package com.accenture.flowershop.be.business;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.repositories.flower.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;

    @Override
    public Flower findById(long id) {
        return flowerRepository.findById(id);
    }

    @Override
    public Flower addFlower(Flower flower) {
        return flowerRepository.saveAndFlush(flower);
    }

    @Override
    public List<Flower> listFlower() {
        return flowerRepository.findAll();
    }

    @Override
    public List<Flower> listFlowers(String name, Integer from, Integer to) {
        Specification<Flower> spec = trueSpec();
        if(name!=null)
        {
            spec = Specification.where(spec).and(nameSpec(name));
        }
        if(from!=null||to!=null)
        {
            spec = Specification.where(spec).and(priceSpec(from, to));
        }
        return flowerRepository.findAll(spec);
    }

    private Specification<Flower> trueSpec()
    {
        return (Specification<Flower>) (root, query, criteriaBuilder) -> criteriaBuilder.and();
    }

    private Specification<Flower> nameSpec(final String name)
    {
        return (Specification<Flower>) (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"),"%"+name+"%");
    }

    private Specification<Flower> priceSpec(final Integer from, final Integer to)
    {
        return (Specification<Flower>) (root, query, criteriaBuilder) -> {
            if(from!=null)
            {
                if(to!=null)
                {
                    return criteriaBuilder.between(root.get("price"), from, to);
                }
                else
                {
                    return criteriaBuilder.ge(root.get("price"), from);
                }
            }
            else
            {
                return criteriaBuilder.le(root.get("price"), to);
            }
        };
    }
}
