package org.example.producer.controller;

import org.example.producer.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<Map<String, String>> sendMessage(
            @RequestParam String name,
            @RequestParam String email) {

        Map<String, String> response = new HashMap<>();

        try {
            messageService.sendMessage(name, email);
            response.put("status", "success");
            response.put("message", "User message sent to RabbitMQ successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Failed to send message", e);
            response.put("status", "error");
            response.put("message", "An internal error occurred. Please try again.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Producer Service is running");
    }
}