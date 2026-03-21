package com.gla.hierarchicalinheritance;
class BankAccount {
    protected String accountNumber;
    protected double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to display general account info
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    private double interestRate; // in percentage

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        displayAccountInfo();
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// CheckingAccount subclass
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        displayAccountInfo();
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}

// FixedDepositAccount subclass
class FixedDepositAccount extends BankAccount {
    private int depositTerm; // in months

    public FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }

    public void displayAccountType() {
        displayAccountInfo();
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Deposit Term: " + depositTerm + " months");
    }
}

// Demo class
public class BankDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA101", 5000, 3.5);
        CheckingAccount checking = new CheckingAccount("CA202", 2000, 1000);
        FixedDepositAccount fd = new FixedDepositAccount("FD303", 10000, 12);

        // Display each account type info
        savings.displayAccountType();
        System.out.println("-----------------------");
        checking.displayAccountType();
        System.out.println("-----------------------");
        fd.displayAccountType();
    }
}

