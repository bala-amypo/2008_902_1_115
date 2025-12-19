package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Temperature Logs")
public class TemperatureLogController {

    private final TemperatureLogService service;

    public TemperatureLogController(TemperatureLogService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureSensorLog record(@RequestBody TemperatureSensorLog log) {
        return service.recordLog(log);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureSensorLog> getByShipment(@PathVariable Long shipmentId) {
        return service.getLogsByShipment(shipmentId);
    }

    @GetMapping("/{id}")
    public TemperatureSensorLog getById(@PathVariable Long id) {
        return service.getLogById(id);
    }

    @GetMapping
    public List<TemperatureSensorLog> getAll() {
        return service.getAllLogs();
    }
}
