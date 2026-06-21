package com.cmms.cmms.controller;

import com.cmms.cmms.entity.Machine;
import com.cmms.cmms.entity.Maintenance;
import com.cmms.cmms.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/machines")
public class MachineController {

    @Autowired
    private MachineService service;

    // Show machines
    @GetMapping
    public String listMachines(Model model) {
        model.addAttribute("machines", service.getAllMachines());
        return "machines";
    }

    // Add machine
    @PostMapping("/add")
    public String addMachine(@ModelAttribute Machine machine) {
        service.saveMachine(machine);
        return "redirect:/machines";
    }
    @GetMapping("/edit/{id}")
    public String editMachine(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "machines",
                service.getAllMachines());

        model.addAttribute(
                "machine",
                service.getMachineById(id));

        return "machines";
    }

    @PostMapping("/update")
    public String updateMachine(
            @ModelAttribute Machine machine) {

        service.saveMachine(machine);

        return "redirect:/machines";
    }
    // Add maintenance record
    @PostMapping("/maintenance")
    public String addMaintenance(@ModelAttribute Maintenance maintenance) {
        service.saveMaintenance(maintenance);
        return "redirect:/machines";
    }
}
