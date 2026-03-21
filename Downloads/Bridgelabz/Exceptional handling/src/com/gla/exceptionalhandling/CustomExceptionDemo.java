package com.gla.exceptionalhandling;
import java.util.Scanner;

// Step 1: Define custom exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Step 2: Class with validateAge method
class AgeValidator {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }
}

// Step 3: Demo class
public class CustomExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");

        try {
            int age = sc.nextInt();
            AgeValidator.validateAge(age); // may throw InvalidAgeException
            System.out.println("Access granted!");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a number.");
        } finally {
            sc.close();
            System.out.println("Program ended.");
        }
    }
}

