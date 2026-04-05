package com.gla.wrapperclasses;
import java.util.ArrayList;

public class StudentMarksReport {

    public static void main(String[] args) {

        // Mixed marks input (String, int, Integer, "null" string)
        Object[] marksInput = {"85", 95, Integer.valueOf(88), "null", "abc", 76};

        ArrayList<Integer> validMarks = new ArrayList<>();

        for (Object mark : marksInput) {
            try {
                if (mark == null) {
                    continue; // Skip null references
                }

                Integer numericMark = null;

                if (mark instanceof String) {
                    String strMark = (String) mark;

                    // Skip "null" string
                    if (strMark.equalsIgnoreCase("null")) {
                        continue;
                    }

                    // Parse valid numeric string
                    numericMark = Integer.parseInt(strMark.trim());

                } else if (mark instanceof Integer) {
                    numericMark = (Integer) mark; // Already Integer
                } else if (mark instanceof int[]) {
                    // Not needed here, but shows how to handle int primitives
                } else if (mark instanceof Number) {
                    numericMark = ((Number) mark).intValue(); // For other Number types
                }

                // Add valid mark
                if (numericMark != null) {
                    validMarks.add(numericMark);
                }

            } catch (NumberFormatException e) {
                // Skip invalid strings like "abc"
                continue;
            }
        }

        // Calculate average
        if (!validMarks.isEmpty()) {
            double sum = 0.0;
            for (Integer mark : validMarks) {
                sum += mark; // Auto-unboxing Integer -> int
            }
            double average = sum / validMarks.size();
            System.out.println("Valid marks: " + validMarks);
            System.out.println("Average mark: " + average);
        } else {
            System.out.println("No valid marks available.");
        }
    }
}
