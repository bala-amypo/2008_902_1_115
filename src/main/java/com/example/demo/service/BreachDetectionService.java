package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.BreachRecord;

public interface BreachDetectionService {

    BreachRecord logBreach(BreachRecord breach);

    List<BreachRecord> getBreachesByShipment(Long shipmentId);

    BreachRecord resolveBreach(Long id);

    BreachRecord getBreachById(Long id);

    List<BreachRecord> getAllBreaches();
}