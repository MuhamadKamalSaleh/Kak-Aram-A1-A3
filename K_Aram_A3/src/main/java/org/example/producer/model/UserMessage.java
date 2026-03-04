package org.example.producer.model;

import java.time.LocalDateTime;

public class UserMessage {

    private String name;
    private String email;
    private LocalDateTime timestamp;

    public UserMessage() {
    }

    public UserMessage(String name, String email, LocalDateTime timestamp) {
        this.name = name;
        this.email = email;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}