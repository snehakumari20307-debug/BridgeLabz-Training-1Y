package com.gla.Collection.QueueInterface;
import java.util.*;

public class GenerateBinaryNumber {

    public static List<String> generateBinaryNumbers(int n) {

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        // Start with "1"
        queue.add("1");

        for (int i = 0; i < n; i++) {

            // Get front element
            String current = queue.remove();

            // Add to result
            result.add(current);

            // Generate next binary numbers
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 5;

        List<String> binaries = generateBinaryNumbers(n);

        System.out.println("Binary Numbers: " + binaries);
    }
}

