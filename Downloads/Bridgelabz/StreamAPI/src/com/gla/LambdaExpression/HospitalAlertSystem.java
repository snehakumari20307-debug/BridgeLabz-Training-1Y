package com.gla.LambdaExpression;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

enum Priority { LOW, MEDIUM, HIGH, CRITICAL }

record Notification(String message, String department, Priority priority, boolean read) {}

public class HospitalAlertSystem {
    public static void main(String[] args) {
        List<Notification> alerts = Arrays.asList(
                new Notification("Patient 402: Heart rate high", "ICU", Priority.CRITICAL, false),
                new Notification("Supplies restocked", "Inventory", Priority.LOW, false),
                new Notification("Patient 105: Lab results ready", "Oncology", Priority.MEDIUM, false),
                new Notification("ER: Incoming ambulance", "Emergency", Priority.HIGH, false)
        );

        // 1. Define Predicates (Filters) using Lambdas
        Predicate<Notification> isCritical = n -> n.priority() == Priority.CRITICAL;
        Predicate<Notification> isHighPriority = n -> n.priority() == Priority.HIGH;
        Predicate<Notification> isEmergencyDept = n -> n.department().equals("Emergency");

        // 2. Combine Predicates: "Show me anything CRITICAL OR anything HIGH in the Emergency Dept"
        Predicate<Notification> urgentFilter = isCritical.or(isHighPriority.and(isEmergencyDept));

        // 3. Apply the filter
        List<Notification> filteredAlerts = alerts.stream()
                .filter(urgentFilter)
                .collect(Collectors.toList());

        // Display results
        System.out.println("--- Active Urgent Alerts ---");
        filteredAlerts.forEach(n -> System.out.println("[" + n.priority() + "] " + n.message()));
    }
}

