package com.gla.MethodReference;
import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    private String transactionId;

    // Constructor that matches the input type
    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice[ID=" + transactionId + "]";
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList("TXN-101", "TXN-102", "TXN-103");

        // Use Constructor Reference (Invoice::new)
        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)
                .collect(Collectors.toList());

        // Print the created objects
        invoices.forEach(System.out::println);
    }
}

