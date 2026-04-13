package com.gla.Collection.Setinterface;
import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {

        // Define two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Add elements to set1
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Add elements to set2
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Create result set for symmetric difference
        Set<Integer> result = new HashSet<>();

        // Add elements from set1 not in set2
        for (Integer num : set1) {
            if (!set2.contains(num)) {
                result.add(num);
            }
        }

        // Add elements from set2 not in set1
        for (Integer num : set2) {
            if (!set1.contains(num)) {
                result.add(num);
            }
        }

        // Print result
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + result);
    }
}

