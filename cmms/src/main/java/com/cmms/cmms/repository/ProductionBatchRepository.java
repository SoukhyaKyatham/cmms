package com.cmms.cmms.repository;

import com.cmms.cmms.entity.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionBatchRepository
        extends JpaRepository<ProductionBatch, Long> {

}