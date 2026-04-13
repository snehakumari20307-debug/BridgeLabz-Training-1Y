package com.gla.generics;
import java.util.*;

public class CopyListElements {

    // Method to copy elements
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        for (Number num : src) {
            dest.add(num); // safe to add Number or its subclasses
        }
    }

    public static void main(String[] args) {

        // Source list (Integer)
        List<Integer> srcList = Arrays.asList(10, 20, 30);

        // Destination list (Number)
        List<Number> destList = new ArrayList<>();

        // Copy elements
        copyList(destList, srcList);

        // Display result
        System.out.println("Destination List: " + destList);
    }
}

