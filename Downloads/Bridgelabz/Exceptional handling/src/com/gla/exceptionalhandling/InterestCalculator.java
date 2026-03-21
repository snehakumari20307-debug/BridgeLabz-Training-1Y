package com.gla.exceptionalhandling;
import java.util.Scanner;

public class InterestCalculator {

    // Method declares it may throw IllegalArgumentException
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        // Explicitly throw exception if input is invalid
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }

        // Simple interest calculation
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter principal amount: ");
            double amount = sc.nextDouble();

            System.out.print("Enter interest rate: ");
            double rate = sc.nextDouble();

            System.out.print("Enter number of years: ");
            int years = sc.nextInt();

            // Call method that may throw exception
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input type!");
        } finally {
            sc.close();
        }
    }
}

