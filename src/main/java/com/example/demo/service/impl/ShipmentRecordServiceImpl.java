package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.repository.ShipmentRecordRepository;
import com.example.demo.service.ShipmentRecordService;

@Service
public class ShipmentRecordServiceImpl implements ShipmentRecordService {

    private final ShipmentRecordRepository repository;

    public ShipmentRecordServiceImpl(ShipmentRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShipmentRecord createShipment(ShipmentRecord shipment) {
        return repository.save(shipment);
    }

    @Override
    public ShipmentRecord updateShipmentStatus(Long id, String status) {
        ShipmentRecord shipment = repository.findById(id).orElse(null);
        if (shipment != null) {
            shipment.setStatus(status);
            return repository.save(shipment);
        }
        return null;
    }

    @Override
    public ShipmentRecord getShipmentByCode(String code) {
        return repository.findByShipmentCode(code);
    }

    @Override
    public ShipmentRecord getShipmentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ShipmentRecord> getAllShipments() {
        return repository.findAll();
    }
}