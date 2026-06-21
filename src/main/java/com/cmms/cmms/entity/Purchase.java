package com.cmms.cmms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private Long chemicalId;
    private double price;
    private int quantity;
}
