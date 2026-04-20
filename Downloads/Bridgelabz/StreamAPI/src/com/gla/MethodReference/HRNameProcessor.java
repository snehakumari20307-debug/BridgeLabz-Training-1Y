package com.gla.MethodReference;
import java.util.*;
import java.util.stream.Collectors;

public class HRNameProcessor {
    public static void main(String[] args) {
        List<String> employeeNames = Arrays.asList(
                "alice smith",
                "bob johnson",
                "charlie davis",
                "diana prince"
        );

        // Transform names using Method Reference
        List<String> formalNames = employeeNames.stream()
                .map(String::toUpperCase) // The method reference
                .collect(Collectors.toList());

        // Output for the HR Letter
        System.out.println("--- Formal Name List ---");
        formalNames.forEach(System.out::println);
    }
}

