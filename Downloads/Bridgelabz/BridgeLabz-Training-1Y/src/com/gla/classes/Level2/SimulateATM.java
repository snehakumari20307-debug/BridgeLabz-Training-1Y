package com.gla.classes.Level2;
// BankAccount.java
class SimulateATM {
    // Attributes
    String accountHolder;
    String accountNumber;
    double balance;

    // Constructor to initialize bank account
    public SimulateATM(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money if sufficient balance exists
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: $" + amount);
            } else {
                System.out.println("Insufficient balance! Current balance: $" + balance);
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to display current balance
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }

    // Main method to test BankAccount class
    public static void main(String[] args) {
        // Creating a BankAccount object
        SimulateATM account1 = new SimulateATM("John Doe", "123456789", 1000.0);

        // Display initial balance
        account1.displayBalance();

        // Deposit money
        account1.deposit(500.0);

        // Withdraw money
        account1.withdraw(200.0);

        // Attempt to withdraw more than balance
        account1.withdraw(2000.0);

        // Display final balance
        account1.displayBalance();
    }
}
