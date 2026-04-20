package com.gla.StreamAPI;
import java.util.*;
import java.util.stream.Collectors;

record Doctor(String name, String specialty, List<String> availableDays) {}

public class HospitalStaffing {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Aris", "Cardiology", List.of("Monday", "Saturday")),
                new Doctor("Dr. Bell", "Neurology", List.of("Wednesday", "Friday")),
                new Doctor("Dr. Chen", "Pediatrics", List.of("Sunday")),
                new Doctor("Dr. Dhan", "Cardiology", List.of("Sunday", "Tuesday")),
                new Doctor("Dr. Evans", "Orthopedics", List.of("Saturday", "Sunday"))
        );

        List<Doctor> weekendStaff = doctors.stream()
                // 1. Filter: Check if availability list contains "Saturday" OR "Sunday"
                .filter(d -> d.availableDays().contains("Saturday") ||
                        d.availableDays().contains("Sunday"))
                // 2. Sort: Alphabetically by Specialty
                .sorted(Comparator.comparing(Doctor::specialty)
                        .thenComparing(Doctor::name)) // Secondary sort by name
                .collect(Collectors.toList());

        System.out.println("--- Weekend On-Call Roster ---");
        weekendStaff.forEach(d ->
                System.out.println("[" + d.specialty() + "] " + d.name()));
    }
}

