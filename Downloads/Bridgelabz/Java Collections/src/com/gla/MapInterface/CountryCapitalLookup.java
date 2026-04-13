package com.gla.MapInterface;
import java.util.*;

public class CountryCapitalLookup {

    public static void main(String[] args) {

        // 1. Map to store country -> capital
        Map<String, String> countryCapital = new HashMap<>();

        // Add at least 8 country-capital pairs
        countryCapital.put("India", "New Delhi");
        countryCapital.put("USA", "Washington D.C.");
        countryCapital.put("Japan", "Tokyo");
        countryCapital.put("France", "Paris");
        countryCapital.put("Germany", "Berlin");
        countryCapital.put("Italy", "Rome");
        countryCapital.put("Canada", "Ottawa");
        countryCapital.put("Australia", "Canberra");

        // 2. Lookup country (simulate user input)
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter country name to search capital: ");
        String country = sc.nextLine();

        if (countryCapital.containsKey(country)) {
            System.out.println("Capital of " + country + " is " + countryCapital.get(country));
        } else {
            System.out.println("Unknown country");
        }

        // 3. Print all countries in alphabetical order
        System.out.println("\n--- Countries in Alphabetical Order ---");

        Map<String, String> sortedMap = new TreeMap<>(countryCapital);

        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        sc.close();
    }
}

