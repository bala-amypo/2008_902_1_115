package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TemperatureSensorLog;

public interface TemperatureLogService {

    TemperatureSensorLog recordLog(TemperatureSensorLog log);

    List<TemperatureSensorLog> getLogsByShipment(Long shipmentId);

    TemperatureSensorLog getLogById(Long id);

    List<TemperatureSensorLog> getAllLogs();
}