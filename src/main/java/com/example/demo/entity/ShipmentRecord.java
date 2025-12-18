package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "shipment_record",
    uniqueConstraints = @UniqueConstraint(columnNames = "shipmentCode")
)
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String shipmentCode;

    private String origin;
    private String destination;
    private String productType;

    private LocalDateTime startDate;
    private LocalDateTime expectedDelivery;

    private String status;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.status = "IN_TRANSIT";
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
}