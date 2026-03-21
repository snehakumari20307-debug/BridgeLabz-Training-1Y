package com.gla.exceptionalhandling;

import java.util.Scanner;

public class NestedTryCatchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input array size
            System.out.print("Enter array size: ");
            int size = sc.nextInt();
            int[] arr = new int[size];

            // Input array elements
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            // Input index and divisor
            System.out.print("Enter index to access: ");
            int index = sc.nextInt();
            System.out.print("Enter divisor: ");
            int divisor = sc.nextInt();

            // Outer try for array access
            try {
                int value = arr[index]; // may throw ArrayIndexOutOfBoundsException

                // Inner try for division
                try {
                    int result = value / divisor; // may throw ArithmeticException
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }

        } catch (Exception e) {
            System.out.println("Invalid input!");
        } finally {
            sc.close();
            System.out.println("Program ended.");
        }
    }
}
