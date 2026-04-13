package com.gla.Collection.Setinterface;
import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {
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

        // UNION (copy set1 and add all elements of set2)
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        // INTERSECTION (keep only common elements)
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // Print results
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}

