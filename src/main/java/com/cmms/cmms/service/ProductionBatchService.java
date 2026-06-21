package com.cmms.cmms.service;

import com.cmms.cmms.entity.ProductionBatch;
import com.cmms.cmms.repository.ProductionBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionBatchService {

    @Autowired
    private ProductionBatchRepository repo;

    public ProductionBatch save(ProductionBatch batch) {
        return repo.save(batch);
    }

    public List<ProductionBatch> getAll() {
        return repo.findAll();
    }
}
