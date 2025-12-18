package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AlertRecord;

public interface AlertService {

    AlertRecord triggerAlert(AlertRecord alert);
    AlertRecord acknowledgeAlert(Long id);
    AlertRecord getAlertById(Long id);
    List<AlertRecord> getAlertsByShipment(Long shipmentId);
    List<AlertRecord> getAllAlerts();
}