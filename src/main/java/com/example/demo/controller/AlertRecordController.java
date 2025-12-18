package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts")
public class AlertRecordController {

    private final AlertService service;

    public AlertRecordController(AlertService service) {
        this.service = service;
    }

    @PostMapping("/")
    public AlertRecord triggerAlert(@RequestBody AlertRecord alert) {
        return service.triggerAlert(alert);
    }

    @PutMapping("/{id}/acknowledge")
    public AlertRecord acknowledgeAlert(@PathVariable Long id) {
        return service.acknowledgeAlert(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<AlertRecord> getByShipment(@PathVariable Long shipmentId) {
        return service.getAlertsByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public AlertRecord getById(@PathVariable Long id) {
        return service.getAlertsByShipment(id).stream().findFirst().orElse(null);
    }

    @GetMapping("/")
    public List<AlertRecord> getAll() {
        return service.getAllAlerts();
    }
}