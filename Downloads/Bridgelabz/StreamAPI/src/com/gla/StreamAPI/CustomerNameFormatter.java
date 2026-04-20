package com.gla.StreamAPI;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerNameFormatter {
    public static void main(String[] args) {
        List<String> customerNames = Arrays.asList(
                "william butch",
                "homelander",
                "starlight",
                "hughie campbell",
                "queen maeve"
        );

        // 1. map() transforms the data
        // 2. sorted() organizes the data
        List<String> formattedNames = customerNames.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        // Display results
        System.out.println("--- Alphabetical Customer Directory ---");
        formattedNames.forEach(System.out::println);
    }
}

