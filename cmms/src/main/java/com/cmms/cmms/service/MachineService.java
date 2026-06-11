package com.cmms.cmms.service;

import com.cmms.cmms.entity.Machine;
import com.cmms.cmms.entity.Maintenance;
import com.cmms.cmms.repository.MachineRepository;
import com.cmms.cmms.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepo;

    @Autowired
    private MaintenanceRepository maintenanceRepo;

    // Machine operations
    public Machine saveMachine(Machine machine) {
        return machineRepo.save(machine);
    }

    public List<Machine> getAllMachines() {
        return machineRepo.findAll();
    }
    public Machine getMachineById(Long id) {

        return machineRepo
                .findById(id)
                .orElse(null);
    }

    // Maintenance operations
    public Maintenance saveMaintenance(Maintenance maintenance) {
        return maintenanceRepo.save(maintenance);
    }

    public List<Maintenance> getAllMaintenance() {
        return maintenanceRepo.findAll();
    }
}
