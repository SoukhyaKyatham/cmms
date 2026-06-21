package com.cmms.cmms.controller;

import com.cmms.cmms.entity.Chemical;
import com.cmms.cmms.entity.OrderEntity;
import com.cmms.cmms.repository.ChemicalRepository;
import com.cmms.cmms.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AlertController {

    @Autowired
    private ChemicalRepository chemicalRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/alerts")
    public String alerts(Model model) {

        List<String> alerts = new ArrayList<>();

        List<Chemical> chemicals = chemicalRepository.findAll();

        int expiryCount = 0;
        int lowStockCount = 0;
        int pendingPaymentCount = 0;

        for (Chemical c : chemicals) {

            if (c.getQuantity() < 10) {
                alerts.add("⚠ Low Stock: " + c.getName());
                lowStockCount++;
            }

            if (c.getExpiryDate() != null &&
                    c.getExpiryDate().isBefore(LocalDate.now().plusDays(30))) {

                alerts.add("⚠ Expiry Alert: " + c.getName());
                expiryCount++;
            }
        }

        List<OrderEntity> orders = orderRepository.findAll();

        for (OrderEntity o : orders) {

            if (o.getPaymentStatus() != null &&
                    o.getPaymentStatus().equalsIgnoreCase("Pending")) {

                alerts.add("💰 Pending Payment: " + o.getCustomerName());
                pendingPaymentCount++;
            }
        }

        model.addAttribute("alerts", alerts);

        model.addAttribute("expiryCount", expiryCount);
        model.addAttribute("lowStockCount", lowStockCount);
        model.addAttribute("pendingPaymentCount", pendingPaymentCount);

        model.addAttribute("maintenanceCount", 0);
        model.addAttribute("totalAlerts", alerts.size());
        return "alerts";
    }
}