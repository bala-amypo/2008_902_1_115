package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Temperature Rules")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @PostMapping("/")
    public TemperatureRule createRule(@RequestBody TemperatureRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TemperatureRule updateRule(
            @PathVariable Long id,
            @RequestBody TemperatureRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/product/{productType}")
    public TemperatureRule getRuleForProduct(
            @PathVariable String productType,
            @RequestParam(required = false) LocalDate date) {

        LocalDate queryDate = (date != null) ? date : LocalDate.now();
        return service.getRuleForProduct(productType, queryDate);
    }

    @GetMapping("/")
    public List<TemperatureRule> getAll() {
        return service.getAllRules();
    }
}