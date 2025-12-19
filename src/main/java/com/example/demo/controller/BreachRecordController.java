package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BreachRecord;
import com.example.demo.service.BreachDetectionService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breach Records")
public class BreachRecordController {

    private final BreachDetectionService service;

    public BreachRecordController(BreachDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public BreachRecord logBreach(@RequestBody BreachRecord breach) {
        return service.logBreach(breach);
    }

    @PutMapping("/{id}/resolve")
    public BreachRecord resolve(@PathVariable Long id) {
        return service.resolveBreach(id);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<BreachRecord> getByShipment(@PathVariable Long shipmentId) {
        return service.getBreachesByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public BreachRecord getById(@PathVariable Long id) {
        return service.getBreachById(id);
    }

    @GetMapping
    public List<BreachRecord> getAll() {
        return service.getAllBreaches();
    }
}
