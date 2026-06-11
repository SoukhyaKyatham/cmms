package com.cmms.cmms.service;

import com.cmms.cmms.entity.Chemical;
import com.cmms.cmms.repository.ChemicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService {

    @Autowired
    private ChemicalRepository chemicalRepo;

    public List<String> getAlerts() {

        List<String> alerts = new ArrayList<>();

        // Expiry Alerts
        List<Chemical> expiring = chemicalRepo
                .findByExpiryDateBefore(LocalDate.now().plusDays(7));

        for (Chemical c : expiring) {
            alerts.add("⚠ Chemical expiring soon: " + c.getName());
        }

        // Low Stock Alerts
        List<Chemical> all = chemicalRepo.findAll();
        for (Chemical c : all) {
            if (c.getQuantity() < 10) {
                alerts.add("⚠ Low stock: " + c.getName());
            }
        }

        return alerts;
    }
}
