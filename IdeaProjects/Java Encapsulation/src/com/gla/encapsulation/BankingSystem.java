package com.gla.encapsulation;

// Interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract Class
abstract class BankAccount {
    // Encapsulation (private fields)
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters & Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    protected void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    protected double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Abstract method
    abstract double calculateInterest();

    // Display
    public void displayDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: ₹" + balance);
    }
}

// SavingsAccount Class
class SavingsAccount extends BankAccount implements Loanable {

    private double interestRate = 0.04; // 4%

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan applied for ₹" + amount + " (Savings Account)");
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 5000;
    }
}

// CurrentAccount Class
class CurrentAccount extends BankAccount implements Loanable {

    private double interestRate = 0.02; // 2%

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan applied for ₹" + amount + " (Current Account)");
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 10000;
    }
}

// Utility class for polymorphism
class BankProcessor {

    public static void processAccounts(BankAccount[] accounts) {
        for (BankAccount acc : accounts) {
            acc.displayDetails();

            double interest = acc.calculateInterest();
            System.out.println("Interest: ₹" + interest);

            // Loan processing via interface
            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                boolean eligible = loanAcc.calculateLoanEligibility();

                System.out.println("Loan Eligible: " + eligible);
                if (eligible) {
                    loanAcc.applyForLoan(50000);
                }
            }

            System.out.println("---------------------------");
        }
    }
}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {

        // Polymorphism
        BankAccount acc1 = new SavingsAccount("SB123", "Rahul", 8000);
        BankAccount acc2 = new CurrentAccount("CA456", "Anita", 15000);

        acc1.deposit(2000);
        acc2.withdraw(3000);

        BankAccount[] accounts = {acc1, acc2};

        BankProcessor.processAccounts(accounts);
    }
}
