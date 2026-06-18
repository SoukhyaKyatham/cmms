package com.cmms.cmms.controller;

import com.cmms.cmms.entity.Chemical;
import com.cmms.cmms.repository.ChemicalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chemicals")
public class ChemicalController {

    @Autowired
    private ChemicalRepository chemicalRepository;

    @GetMapping
    public String chemicals(Model model){

        model.addAttribute(
                "chemicals",
                chemicalRepository.findAll());

        return "chemicals";
    }

    @PostMapping("/add")
    public String addChemical(
            Chemical chemical){

        chemicalRepository.save(
                chemical);

        return "redirect:/chemicals";
    }

    // STEP 2 - OPEN EDIT PAGE

    @GetMapping("/edit/{id}")
    public String editChemical(
            @PathVariable Long id,
            Model model){

        Chemical chemical =
                chemicalRepository.findById(id)
                        .orElse(null);

        model.addAttribute(
                "chemical",
                chemical);

        return "edit-chemical";
    }

    // STEP 3 - UPDATE CHEMICAL
    @PostMapping("/update")
    public String updateChemical(Chemical chemical){

        chemicalRepository.save(chemical);

        return "redirect:/chemicals";
    }

}