// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.User;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;

// import io.swagger.v3.oas.annotations.tags.Tag;

// @RestController
// @RequestMapping("/auth")
// @Tag(name = "Authentication")
// public class AuthController {

//     private final UserService userService;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserService userService, JwtUtil jwtUtil) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/register")
//     public String register(@RequestBody RegisterRequest request) {
//         User user = new User();
//         user.setFullName(request.getFullName());
//         user.setEmail(request.getEmail());
//         user.setPassword(request.getPassword());

//         User savedUser = userService.registerUser(user);

//         return jwtUtil.generateToken(
//                 savedUser.getId(),
//                 savedUser.getEmail(),
//                 savedUser.getRole()
//         );
//     }

//     @PostMapping("/login")
//     public String login(@RequestBody LoginRequest request) {

//         User user = userService.findByEmail(request.getEmail());

//         if (user == null) {
//             throw new RuntimeException("Invalid credentials");
//         }

//         return jwtUtil.generateToken(
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole()
//         );
//     }
// }



package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_records")
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long breachId;
    private boolean acknowledged;
    private LocalDateTime sentAt;

    public AlertRecord() {
    }

    public AlertRecord(Long shipmentId, Long breachId,
                       boolean acknowledged, LocalDateTime sentAt) {
        this.shipmentId = shipmentId;
        this.breachId = breachId;
        this.acknowledged = acknowledged;
        this.sentAt = sentAt;
    }

    @PrePersist
    public void prePersist() {
        this.acknowledged = false;
        this.sentAt = LocalDateTime.now();
    }

    // GETTERS
    public Long getId() {
        return id;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public Long getBreachId() {
        return breachId;
    }

    public boolean isAcknowledged() {
        return acknowledged;
    }

    // REQUIRED BY TESTS
    public boolean getAcknowledged() {
        return acknowledged;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setBreachId(Long breachId) {
        this.breachId = breachId;
    }

    public void setAcknowledged(boolean acknowledged) {
        this.acknowledged = acknowledged;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}
