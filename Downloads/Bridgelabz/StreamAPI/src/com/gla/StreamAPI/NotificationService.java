package com.gla.StreamAPI;
import java.util.*;

public class NotificationService {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
                "user1@hospital.com",
                "user2@ecommerce.com",
                "admin@iot-hub.net"
        );

        System.out.println("--- Starting Email Dispatch ---");

        // Using forEach to trigger the external method
        emails.forEach(email -> sendEmailNotification(email));

        // Alternatively, using a Method Reference for even cleaner code:
        // emails.forEach(NotificationService::sendEmailNotification);

        System.out.println("--- All notifications queued ---");
    }

    // Mock method representing your email sending logic
    public static void sendEmailNotification(String email) {
        // In a real app, this would connect to an SMTP server or API
        System.out.println("Notification successfully sent to: " + email);
    }
}

