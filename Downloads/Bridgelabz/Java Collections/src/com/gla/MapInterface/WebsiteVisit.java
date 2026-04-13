package com.gla.MapInterface;
import java.util.*;

public class WebsiteVisit {

    private Map<String, Integer> visits = new HashMap<>();

    // 1. Track page visit
    public void visitPage(String page) {
        visits.put(page, visits.getOrDefault(page, 0) + 1);
        System.out.println("Visited: " + page);
    }

    // 2. Print pages sorted by descending visits
    public void printSortedReport() {

        System.out.println("\n--- Page Visit Report (Descending Order) ---");

        // Convert map to list for sorting
        List<Map.Entry<String, Integer>> list = new ArrayList<>(visits.entrySet());

        // Sort by value (descending)
        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // 3. Find most visited page
    public void printMostVisited() {

        if (visits.isEmpty()) {
            System.out.println("No visits recorded.");
            return;
        }

        String maxPage = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : visits.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxPage = entry.getKey();
            }
        }

        System.out.println("\n🔥 Most Visited Page: " + maxPage + " -> " + maxCount + " visits");
    }

    public static void main(String[] args) {

        WebsiteVisit tracker = new WebsiteVisit();

        // 4. Simulated page visits
        String[] sessionVisits = {
                "home", "about", "products", "home", "products",
                "contact", "home", "products", "about", "home"
        };

        for (String page : sessionVisits) {
            tracker.visitPage(page);
        }

        // 5. Generate report
        tracker.printSortedReport();

        // 6. Most visited page
        tracker.printMostVisited();
    }
}

