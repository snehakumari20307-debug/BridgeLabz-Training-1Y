package com.gla.StreamAPI;
import java.util.*;
import java.util.stream.Collectors;

record Claim(String id, String type, double amount) {}

public class ClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C101", "Medical", 1500.0),
                new Claim("C102", "Auto", 3500.0),
                new Claim("C103", "Medical", 2500.0),
                new Claim("C104", "Home", 12000.0),
                new Claim("C105", "Auto", 4500.0),
                new Claim("C106", "Medical", 500.0)
        );

        // Group by 'type' and calculate the average of 'amount'
        Map<String, Double> averageByClaimType = claims.stream()
                .collect(Collectors.groupingBy(
                        Claim::type,
                        Collectors.averagingDouble(Claim::amount)
                ));

        // Display the results
        System.out.println("--- Average Claim Amount by Type ---");
        averageByClaimType.forEach((type, avg) ->
                System.out.printf("%-10s: $%,.2f%n", type, avg));
    }
}

