package com.cmms.cmms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;     // Mixer, Filling Machine
    private String status;   // Working / Maintenance
}
