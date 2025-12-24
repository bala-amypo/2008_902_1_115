package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentRecordController {

    private final ShipmentRecordService service;

    public ShipmentRecordController(ShipmentRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ShipmentRecord create(@RequestBody ShipmentRecord shipment) {
        return service.createShipment(shipment);
    }

    @PutMapping("/{id}/status")
    public ShipmentRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateShipmentStatus(id, status);
    }

    @GetMapping("/code/{shipmentCode}")
    public ShipmentRecord getByCode(@PathVariable String shipmentCode) {
        return service.getShipmentByCode(shipmentCode).orElse(null);
    }

    @GetMapping("/{id}")
    public ShipmentRecord getById(@PathVariable Long id) {
        return service.getShipmentById(id);
    }

    @GetMapping
    public List<ShipmentRecord> getAll() {
        return service.getAllShipments();
    }
}
