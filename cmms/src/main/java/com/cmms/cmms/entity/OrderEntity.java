package com.cmms.cmms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String status;         // Pending / Dispatched
    private String paymentStatus;  // Paid / Pending
}
