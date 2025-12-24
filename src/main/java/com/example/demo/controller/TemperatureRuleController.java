package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;

@RestController
@RequestMapping("/api/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureRule create(@RequestBody TemperatureRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TemperatureRule update(
            @PathVariable Long id,
            @RequestBody TemperatureRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActive() {
        return service.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public TemperatureRule getForProduct(
            @PathVariable String productType,
            @RequestParam(required = false) LocalDate date) {

        return service
                .getRuleForProduct(
                        productType,
                        date != null ? date : LocalDate.now()
                )
                .orElse(null);
    }

    @GetMapping
    public List<TemperatureRule> getAll() {
        return service.getAllRules();
    }
}
