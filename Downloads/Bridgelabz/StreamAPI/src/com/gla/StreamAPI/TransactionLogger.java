package com.gla.StreamAPI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TransactionLogger {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
                "TXN-88210",
                "TXN-88211",
                "TXN-88212",
                "TXN-88213"
        );

        // Formatter for a cleaner, more readable timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("--- Transaction Log Start ---");

        // Using forEach with a lambda to include the timestamp
        transactionIds.forEach(id -> {
            String timestamp = LocalDateTime.now().format(formatter);
            System.out.println(timestamp + " - Transaction: " + id);
        });

        System.out.println("--- Transaction Log End ---");
    }
}

