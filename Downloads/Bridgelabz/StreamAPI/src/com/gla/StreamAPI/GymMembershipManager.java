package com.gla.StreamAPI;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

record Member(String name, LocalDate expiryDate) {}

public class GymMembershipManager {
    public static void main(String[] args) {
        // Mock data
        List<Member> members = Arrays.asList(
                new Member("Alex", LocalDate.now().plusDays(10)), // Expires soon
                new Member("Jordan", LocalDate.now().plusDays(45)),
                new Member("Taylor", LocalDate.now().plusDays(5)),  // Expires soon
                new Member("Casey", LocalDate.now().minusDays(2))  // Already expired
        );

        // 1. Define the timeframe: Today and 30 days from now
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysFromNow = today.plusDays(30);

        // 2. Filter: Expiry date is after (or equal to) today AND before/equal to 30 days from now
        List<Member> expiringSoon = members.stream()
                .filter(m -> !m.expiryDate().isBefore(today)) // Exclude already expired
                .filter(m -> m.expiryDate().isBefore(thirtyDaysFromNow))
                .collect(Collectors.toList());

        // Display results
        System.out.println("--- Members Expiring Within 30 Days ---");
        expiringSoon.forEach(m ->
                System.out.println(m.name() + " (Expires: " + m.expiryDate() + ")"));
    }
}

