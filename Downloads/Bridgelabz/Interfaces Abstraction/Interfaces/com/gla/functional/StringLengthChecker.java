package com.gla.functional;
import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        String message = "Hello, this is a test message!";
        int limit = 20;

        // Function to get string length
        Function<String, Integer> getLength = str -> str.length();

        if (getLength.apply(message) > limit) {
            System.out.println("Message exceeds limit (" + limit + " chars). Actual length: " + getLength.apply(message));
        } else {
            System.out.println("Message is within the limit.");
        }
    }
}

