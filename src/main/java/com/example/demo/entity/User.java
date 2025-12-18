package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "users",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;
    private String role;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.role = "MONITOR";
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
}