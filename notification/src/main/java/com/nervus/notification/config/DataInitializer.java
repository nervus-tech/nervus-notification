package com.nervus.notification.config;

import com.nervus.notification.model.Notification;
import com.nervus.notification.repository.NotificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    private final NotificationRepository notificationRepository;

    public DataInitializer(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists to avoid duplication
        if (notificationRepository.count() == 0) {
            // Seed sample notifications
            Notification notification1 = new Notification(
                1L, // User ID 1 (Raphael from nervus-authentication)
                "Welcome to Nervus!",
                LocalDateTime.now()
            );
            Notification notification2 = new Notification(
                2L, // User ID 2 (John Smith from nervus-user)
                "Assignment due in 7 days",
                LocalDateTime.now()
            );
            notificationRepository.save(notification1);
            notificationRepository.save(notification2);
            System.out.println("Seeded 2 notifications into notifications");
        } else {
            System.out.println("Notifications already seeded, skipping...");
        }
    }
}