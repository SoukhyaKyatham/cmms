package com.cmms.cmms.controller;

import com.cmms.cmms.entity.ProductionBatch;
import com.cmms.cmms.repository.ProductionBatchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/batches")
public class ProductionBatchController {

    @Autowired
    private ProductionBatchRepository repository;

    @GetMapping
    public String showPage(Model model) {

        model.addAttribute("batches", repository.findAll());

        return "batches";
    }

    @PostMapping("/add")
    public String addBatch(ProductionBatch batch) {

        repository.save(batch);

        return "redirect:/batches";
    }
    @GetMapping("/edit/{id}")
    public String editBatch(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "batches",
                repository.findAll());

        model.addAttribute(
                "batch",
                repository.findById(id).orElse(null));

        return "batches";
    }


    @PostMapping("/update")
    public String updateBatch(
            ProductionBatch batch) {

        repository.save(batch);

        return "redirect:/batches";
    }
}
