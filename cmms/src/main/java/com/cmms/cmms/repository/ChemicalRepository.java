package com.cmms.cmms.repository;

import com.cmms.cmms.entity.Chemical;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ChemicalRepository extends JpaRepository<Chemical, Long> {

    List<Chemical> findByExpiryDateBefore(LocalDate date);
}
