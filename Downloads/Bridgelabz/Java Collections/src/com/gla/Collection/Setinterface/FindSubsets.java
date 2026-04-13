package com.gla.Collection.Setinterface;
import java.util.HashSet;
import java.util.Set;

public class FindSubsets {
    public static void main(String[] args) {

        // Define Set1 and Set2
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Set1 elements
        set1.add(2);
        set1.add(3);

        // Set2 elements
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Check if set1 is subset of set2
        boolean isSubset = set2.containsAll(set1);

        // Output result
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Is Set1 a subset of Set2? " + isSubset);
    }
}
