package com.gla.exceptionalhandling;
import java.util.Scanner;

// Step 1: Define custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Step 2: BankAccount class
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Withdraw method
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!"); // negative amount
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!"); // not enough balance
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
}

// Step 3: Demo class
public class BankTransactionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000); // initial balance $1000

        System.out.println("Current balance: " + account.getBalance());
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount); // may throw exceptions
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
            System.out.println("Transaction ended.");
        }
    }
}

