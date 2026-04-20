package com.gla.MethodReference;
import java.util.*;

record Patient(String id, String name, int age) {}

public class PatientIdPrinter {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
                new Patient("P-9901", "Alice Smith", 45),
                new Patient("P-9902", "Bob Johnson", 32),
                new Patient("P-9903", "Charlie Davis", 67),
                new Patient("P-9904", "Diana Prince", 29)
        );

        System.out.println("--- Patient ID Verification List ---");

        // Using Method References
        patients.stream()
                .map(Patient::id)           // Shorthand for: p -> p.id()
                .forEach(System.out::println); // Shorthand for: id -> System.out.println(id)
    }
}

