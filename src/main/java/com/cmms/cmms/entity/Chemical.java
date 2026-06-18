package com.cmms.cmms.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Chemical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length=1000)
    private String description;

    private String batchNo;

    private LocalDate expiryDate;

    private int quantity;

    private String specification;

    private String rawMaterial;

    private String imageUrl;
}
