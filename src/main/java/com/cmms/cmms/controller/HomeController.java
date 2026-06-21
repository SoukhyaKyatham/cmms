package com.cmms.cmms.controller;

import com.cmms.cmms.repository.ChemicalRepository;
import com.cmms.cmms.repository.ProductionBatchRepository;
import com.cmms.cmms.repository.MachineRepository;
import com.cmms.cmms.repository.SupplierRepository;
import com.cmms.cmms.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    ChemicalRepository chemicalRepository;

    @Autowired
    ProductionBatchRepository productionBatchRepository;

    @Autowired
    MachineRepository machineRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){

        model.addAttribute("chemicalCount",
                chemicalRepository.count());

        model.addAttribute("batchCount",
                productionBatchRepository.count());

        model.addAttribute("machineCount",
                machineRepository.count());

        model.addAttribute("supplierCount",
                supplierRepository.count());

        model.addAttribute("orderCount",
                orderRepository.count());

        return "index";
    }
}