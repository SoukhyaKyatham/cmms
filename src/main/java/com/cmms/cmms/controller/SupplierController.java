package com.cmms.cmms.controller;

import com.cmms.cmms.entity.Supplier;
import com.cmms.cmms.entity.Purchase;
import com.cmms.cmms.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService service;

    // Show suppliers
    @GetMapping
    public String listSuppliers(Model model) {
        model.addAttribute("suppliers", service.getAllSuppliers());
        model.addAttribute("purchases", service.getAllPurchases());
        return "suppliers";
    }

    // Add supplier
    @PostMapping("/add")
    public String addSupplier(@ModelAttribute Supplier supplier) {
        service.saveSupplier(supplier);
        return "redirect:/suppliers";
    }
    @GetMapping("/edit/{id}")
    public String editSupplier(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "suppliers",
                service.getAllSuppliers());

        model.addAttribute(
                "purchases",
                service.getAllPurchases());

        model.addAttribute(
                "supplier",
                service.getSupplierById(id));

        return "suppliers";
    }

    @PostMapping("/update")
    public String updateSupplier(
            @ModelAttribute Supplier supplier) {

        service.saveSupplier(supplier);

        return "redirect:/suppliers";
    }
    // Add purchase
    @PostMapping("/purchase")
    public String addPurchase(@ModelAttribute Purchase purchase) {
        service.savePurchase(purchase);
        return "redirect:/suppliers";
    }
}