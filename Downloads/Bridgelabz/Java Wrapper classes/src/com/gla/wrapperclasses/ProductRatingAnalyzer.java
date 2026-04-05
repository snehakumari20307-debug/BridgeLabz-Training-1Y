package com.gla.wrapperclasses;
import java.util.ArrayList;
import java.util.Objects;

public class ProductRatingAnalyzer {

    public static void main(String[] args) {
        // Primitive ratings from old system
        int[] primitiveRatings = {5, 4, 3, 5, 2};

        // Ratings from new system (may contain nulls)
        ArrayList<Integer> objectRatings = new ArrayList<>();
        objectRatings.add(4);
        objectRatings.add(null);
        objectRatings.add(5);
        objectRatings.add(3);

        // Combined list of Integer objects
        ArrayList<Integer> allRatings = new ArrayList<>();

        // Add primitive ratings (autoboxing converts int -> Integer)
        for (int rating : primitiveRatings) {
            allRatings.add(rating);
        }

        // Add object ratings, filtering out nulls
        for (Integer rating : objectRatings) {
            if (Objects.nonNull(rating)) {
                allRatings.add(rating);
            }
        }

        // Calculate average rating
        if (!allRatings.isEmpty()) {
            double sum = 0.0;
            for (Integer rating : allRatings) {
                // Auto-unboxing Integer -> int
                sum += rating;
            }
            double average = sum / allRatings.size();
            System.out.println("Average Rating: " + average);
        } else {
            System.out.println("No valid ratings available.");
        }
    }
}

