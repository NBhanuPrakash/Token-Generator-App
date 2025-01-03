package com.NNTeachie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tokens")
public class UsersTokens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token_hash")
    private String tokenHash;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "token_type")
    private String tokenType;

    @Column(name = "issued_at", nullable = false)
    private LocalDateTime issuedAt;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name = "last_used")
    private LocalDateTime lastUsed;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "revoked_at")
    private LocalDateTime revokedAt;

    @Column(name = "scope")
    private String scope;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "user_agent")
    private String userAgent;

    @Column(name = "issuer")
    private String issuer;

    @Column(name = "audience")
    private String audience;

    @Column(name = "roles")
    private String roles;

    public UsersTokens() {
    }

    public UsersTokens(Long id, String tokenHash, Integer userId, String username, String passwordHash, String tokenType, LocalDateTime issuedAt, LocalDateTime expiresAt, LocalDateTime lastUsed, Boolean isActive, LocalDateTime revokedAt, String scope, String deviceId, String ipAddress, String userAgent, String issuer, String audience, String roles) {
        this.id = id;
        this.tokenHash = tokenHash;
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.tokenType = tokenType;
        this.issuedAt = issuedAt;
        this.expiresAt = expiresAt;
        this.lastUsed = lastUsed;
        this.isActive = isActive;
        this.revokedAt = revokedAt;
        this.scope = scope;
        this.deviceId = deviceId;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
        this.issuer = issuer;
        this.audience = audience;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenHash() {
        return tokenHash;
    }

    public void setTokenHash(String tokenHash) {
        this.tokenHash = tokenHash;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(LocalDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getRevokedAt() {
        return revokedAt;
    }

    public void setRevokedAt(LocalDateTime revokedAt) {
        this.revokedAt = revokedAt;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
