package com.gla.MapInterface;
import java.util.*;

public class BankingSystem {

    private Map<String, Double> accounts = new HashMap<>();

    // 1. Add new customer account
    public void addAccount(String accNo, double balance) {
        accounts.put(accNo, balance);
        System.out.println("Account created: " + accNo + " -> " + balance);
    }

    // 2. Deposit
    public void deposit(String accNo, double amount) {
        if (!accounts.containsKey(accNo)) {
            System.out.println("Account not found: " + accNo);
            return;
        }

        accounts.put(accNo, accounts.get(accNo) + amount);
        System.out.println("Deposited " + amount + " to " + accNo);
    }

    // 2. Withdraw with balance check
    public void withdraw(String accNo, double amount) {
        if (!accounts.containsKey(accNo)) {
            System.out.println("Account not found: " + accNo);
            return;
        }

        double currentBalance = accounts.get(accNo);

        if (amount > currentBalance) {
            System.out.println("Insufficient balance in " + accNo);
            return;
        }

        accounts.put(accNo, currentBalance - amount);
        System.out.println("Withdrawn " + amount + " from " + accNo);
    }

    // 3. Print all customers sorted by descending balance
    public void printSortedCustomers() {

        System.out.println("\n--- Customers Sorted by Balance (Descending) ---");

        List<Map.Entry<String, Double>> list = new ArrayList<>(accounts.entrySet());

        list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        for (Map.Entry<String, Double> entry : list) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // 4. Top 3 customers
    public void printTop3Customers() {

        System.out.println("\n🏆 Top 3 Customers:");

        List<Map.Entry<String, Double>> list = new ArrayList<>(accounts.entrySet());

        list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        for (int i = 0; i < Math.min(3, list.size()); i++) {
            Map.Entry<String, Double> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        BankingSystem bank = new BankingSystem();

        // 1. Add accounts
        bank.addAccount("A101", 5000);
        bank.addAccount("A102", 12000);
        bank.addAccount("A103", 8000);
        bank.addAccount("A104", 15000);
        bank.addAccount("A105", 3000);

        // 2. Transactions
        bank.deposit("A101", 2000);
        bank.withdraw("A102", 5000);
        bank.withdraw("A105", 5000); // insufficient balance
        bank.deposit("A103", 4000);

        // 3. Sorted list
        bank.printSortedCustomers();

        // 4. Top 3
        bank.printTop3Customers();
    }
}

