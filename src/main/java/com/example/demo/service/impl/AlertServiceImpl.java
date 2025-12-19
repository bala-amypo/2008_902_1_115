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

    public AlertRecord triggerAlert(AlertRecord alert) {
        return repository.save(alert);
    }

    public AlertRecord acknowledgeAlert(Long id) {
        AlertRecord alert = repository.findById(id).orElse(null);
        if (alert != null) {
            alert.setAcknowledged(true);
            return repository.save(alert);
        }
        return null;
    }

    public AlertRecord getAlertById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<AlertRecord> getAlertsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public List<AlertRecord> getAllAlerts() {
        return repository.findAll();
    }
}