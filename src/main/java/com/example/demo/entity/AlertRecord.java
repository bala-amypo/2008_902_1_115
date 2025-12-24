package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_records")
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long breachId;
    private boolean acknowledged;
    private LocalDateTime sentAt;

    public AlertRecord() {
    }

    public AlertRecord(Long shipmentId, Long breachId,
                       boolean acknowledged, LocalDateTime sentAt) {
        this.shipmentId = shipmentId;
        this.breachId = breachId;
        this.acknowledged = acknowledged;
        this.sentAt = sentAt;
    }

    @PrePersist
    public void prePersist() {
        this.acknowledged = false;
        this.sentAt = LocalDateTime.now();
    }

    // GETTERS
    public Long getId() {
        return id;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public Long getBreachId() {
        return breachId;
    }

    public boolean isAcknowledged() {
        return acknowledged;
    }

    // REQUIRED BY TESTS
    public boolean getAcknowledged() {
        return acknowledged;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setBreachId(Long breachId) {
        this.breachId = breachId;
    }

    public void setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}
