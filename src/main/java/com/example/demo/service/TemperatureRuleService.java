package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.entity.TemperatureRule;

public interface TemperatureRuleService {

    TemperatureRule createRule(TemperatureRule rule);

    TemperatureRule updateRule(Long id, TemperatureRule rule);

    List<TemperatureRule> getActiveRules();

    TemperatureRule getRuleForProduct(String productType, LocalDate date);

    List<TemperatureRule> getAllRules();
}