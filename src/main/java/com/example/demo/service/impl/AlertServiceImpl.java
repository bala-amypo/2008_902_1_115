package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import com.example.demo.service.AlertService;

@Service
public class AlertServiceImpl implements AlertService {

    private final AlertRecordRepository repository;

    public AlertServiceImpl(AlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public AlertRecord triggerAlert(AlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public AlertRecord acknowledgeAlert(Long id) {
        AlertRecord alert = repository.findById(id).orElse(null);
        if (alert != null) {
            alert.setAcknowledged(true);
            return repository.save(alert);
        }
        return null;
    }

    @Override
    public List<AlertRecord> getAlertsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    @Override
    public List<AlertRecord> getAllAlerts() {
        return repository.findAll();
    }
}