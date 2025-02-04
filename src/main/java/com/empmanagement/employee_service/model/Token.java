package com.empmanagement.employee_service.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;

@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tokenId;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiredTime;

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Token() {
        this.token = generateRandomToken();
        this.createdAt = LocalDateTime.now();
        this.expiredTime = createdAt.plusMinutes(5); // Adds 5 minutes
    }

    private String generateRandomToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16]; // 16 bytes = 128-bit token
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", createdAt=" + createdAt +
                ", expiredTime=" + expiredTime +
                '}';
    }


}
