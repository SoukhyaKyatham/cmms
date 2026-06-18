package com.cmms.cmms.service;

import com.cmms.cmms.entity.OrderEntity;
import com.cmms.cmms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public OrderEntity save(OrderEntity order) {
        return repo.save(order);
    }

    public List<OrderEntity> getAll() {
        return repo.findAll();
    }
    public OrderEntity getById(Long id) {

        return repo
                .findById(id)
                .orElse(null);
    }
}
