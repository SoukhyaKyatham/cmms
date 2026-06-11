package com.cmms.cmms.service;

import com.cmms.cmms.entity.Chemical;
import com.cmms.cmms.repository.ChemicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChemicalService {

    @Autowired
    private ChemicalRepository repo;

    public Chemical save(Chemical chemical) {
        return repo.save(chemical);
    }

    public List<Chemical> getAll() {
        return repo.findAll();
    }

    public List<Chemical> getExpiringSoon() {
        return repo.findByExpiryDateBefore(LocalDate.now().plusDays(7));
    }
}