package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BreachRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long logId;
    private String breachType;
    private Double breachValue;
    private String severity;
    private String details;
    private LocalDateTime detectedAt;
    private Boolean resolved;

    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
        this.resolved = false;
    }

    public Long getId() { return id; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}