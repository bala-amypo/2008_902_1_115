package com.example.demo.security;

public class JwtUtil {

    private final String secret;
    private final long validityInMs;

    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(String email, Long userId, String role) {
        return "dummy-jwt-token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String extractEmail(String token) {
        return "";
    }

    public Long extractUserId(String token) {
        return 0L;
    }

    public String extractRole(String token) {
        return "";
    }
}