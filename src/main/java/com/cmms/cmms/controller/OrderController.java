package com.cmms.cmms.controller;

import com.cmms.cmms.entity.OrderEntity;
import com.cmms.cmms.service.InvoiceService;
import com.cmms.cmms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;
    @Autowired
    private InvoiceService invoiceService;

    // Show all orders
    @GetMapping
    public String list(Model model) {
        model.addAttribute("orders", service.getAll());
        return "orders";
    }

    // Add order
    @PostMapping("/add")
    public String add(@ModelAttribute OrderEntity order) {
        service.save(order);
        // Generate PDF Invoice
        invoiceService.generateInvoice(order.getCustomerName(), 500.0);
        return "redirect:/orders";
    }
    @GetMapping("/edit/{id}")
    public String editOrder(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "orders",
                service.getAll());

        model.addAttribute(
                "order",
                service.getById(id));

        return "orders";
    }

    @PostMapping("/update")
    public String updateOrder(
            @ModelAttribute OrderEntity order) {

        service.save(order);

        return "redirect:/orders";
    }
}
