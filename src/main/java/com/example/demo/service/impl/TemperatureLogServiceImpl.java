package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.repository.TemperatureSensorLogRepository;
import com.example.demo.service.TemperatureLogService;

@Service
public class TemperatureLogServiceImpl implements TemperatureLogService {

    private final TemperatureSensorLogRepository repository;

    public TemperatureLogServiceImpl(TemperatureSensorLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public TemperatureSensorLog recordLog(TemperatureSensorLog log) {
        return repository.save(log);
    }

    @Override
    public List<TemperatureSensorLog> getLogsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    @Override
    public TemperatureSensorLog getLogById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<TemperatureSensorLog> getAllLogs() {
        return repository.findAll();
    }
}