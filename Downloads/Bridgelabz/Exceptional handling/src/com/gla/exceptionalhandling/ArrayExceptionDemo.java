package com.gla.exceptionalhandling;
import java.util.Scanner;

public class ArrayExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = null;

        try {
            // Step 1: Input array size
            System.out.print("Enter size of the array: ");
            int size = sc.nextInt();

            // Step 2: Initialize array
            arr = new int[size];

            // Step 3: Input array elements
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            // Step 4: Input index to retrieve
            System.out.print("Enter index to retrieve value: ");
            int index = sc.nextInt();

            // Step 5: Access array
            System.out.println("Value at index " + index + " is " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of bounds!");
        } catch (NullPointerException e) {
            System.out.println("Error: Array is null!");
        } catch (Exception e) {
            System.out.println("Error: Invalid input!");
        } finally {
            sc.close();
            System.out.println("Program ended.");
        }
    }
}

