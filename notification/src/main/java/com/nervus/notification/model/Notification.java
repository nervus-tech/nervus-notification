package com.nervus.notification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications",schema = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private String message;
    private LocalDateTime sent_at;

    // Getters, setters, constructors
    public Notification() {}
    public Notification(Long user_id, String message, LocalDateTime sent_at) {
        this.user_id = user_id;
        this.message = message;
        this.sent_at = sent_at;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public LocalDateTime getSent_at() { return sent_at; }
    public void setSent_at(LocalDateTime sent_at) { this.sent_at = sent_at; }
}