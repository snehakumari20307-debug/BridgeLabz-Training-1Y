package com.gla.Collection.Setinterface;
import java.util.*;

public class ConvertSortedList {
    public static void main(String[] args) {

        // Create a HashSet
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        // Convert Set to List
        List<Integer> list = new ArrayList<>(set);

        // Sort the list
        Collections.sort(list);

        // Print result
        System.out.println("Sorted List: " + list);
    }
}

