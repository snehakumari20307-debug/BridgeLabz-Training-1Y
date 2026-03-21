package com.gla.exceptionalhandling;
import java.util.Scanner;

public class DivisionFinallyDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Take two integers as input
            System.out.print("Enter numerator: ");
            int numerator = sc.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = sc.nextInt();

            // Perform division
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter integers.");
        } finally {
            // This block executes regardless of exceptions
            System.out.println("Operation completed.");
            sc.close();
        }
    }
}

