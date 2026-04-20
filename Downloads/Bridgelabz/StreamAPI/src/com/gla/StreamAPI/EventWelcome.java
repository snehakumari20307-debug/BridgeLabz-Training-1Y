package com.gla.StreamAPI;
import java.util.*;

public class EventWelcome {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList(
                "James Holden",
                "Naomi Nagata",
                "Amos Burton",
                "Alex Kamal"
        );

        System.out.println("--- Generating Welcome Messages ---");

        // Using forEach() with a lambda expression
        attendees.forEach(name ->
                System.out.println("Welcome to the 2026 Tech Summit, " + name + "! Check in at Desk A."));
    }
}

