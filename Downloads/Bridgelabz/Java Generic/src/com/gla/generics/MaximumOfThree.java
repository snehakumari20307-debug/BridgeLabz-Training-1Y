package com.gla.generics;
public class MaximumOfThree {

    // Generic method with bounded type
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }

        return max;
    }

    public static void main(String[] args) {

        // Test with Integer
        System.out.println("Max Integer: " + maximum(10, 25, 15));

        // Test with Double
        System.out.println("Max Double: " + maximum(5.5, 2.2, 9.8));

        // Test with String
        System.out.println("Max String: " + maximum("Apple", "Banana", "Mango"));
    }
}

