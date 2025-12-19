package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import com.example.demo.service.BreachDetectionService;

@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository repository;

    public BreachDetectionServiceImpl(BreachRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public BreachRecord logBreach(BreachRecord breach) {
        return repository.save(breach);
    }

    @Override
    public List<BreachRecord> getBreachesByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    @Override
    public BreachRecord resolveBreach(Long id) {
        BreachRecord breach = repository.findById(id).orElse(null);
        if (breach != null) {
            breach.setResolved(true);
            return repository.save(breach);
        }
        return null;
    }

    @Override
    public BreachRecord getBreachById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<BreachRecord> getAllBreaches() {
        return repository.findAll();
    }
}