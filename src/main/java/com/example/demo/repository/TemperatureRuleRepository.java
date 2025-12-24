// package com.example.demo.repository;

// import java.time.LocalDate;
// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import com.example.demo.entity.TemperatureRule;

// public interface TemperatureRuleRepository
//         extends JpaRepository<TemperatureRule, Long> {

//     List<TemperatureRule> findByActiveTrue();

//     @Query("""
//         SELECT r FROM TemperatureRule r
//         WHERE r.productType = :productType
//           AND r.active = true
//           AND :date BETWEEN r.effectiveFrom AND r.effectiveTo
//     """)
//     TemperatureRule findApplicableRule(
//             @Param("productType") String productType,
//             @Param("date") LocalDate date
//     );
// }



package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.TemperatureRule;

public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    List<TemperatureRule> findByActiveTrue();

    @Query("""
        SELECT r FROM TemperatureRule r
        WHERE r.productType = :productType
          AND r.active = true
          AND :date BETWEEN r.effectiveFrom AND r.effectiveTo
    """)
    Optional<TemperatureRule> findApplicableRule(
            @Param("productType") String productType,
            @Param("date") LocalDate date
    );
}
