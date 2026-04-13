package com.gla.Collection;
import java.util.*;

// Account class
class Account {
    String accountId;
    String name;
    double balance;

    public Account(String accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return accountId + " (" + name + ") Balance: " + balance;
    }

    // For Set uniqueness
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account acc = (Account) o;
        return accountId.equals(acc.accountId);
    }

    @Override
    public int hashCode() {
        return accountId.hashCode();
    }
}

// Transaction class
class Transaction {
    String transactionId;
    String accountId;
    double amount; // +deposit, -withdraw

    public Transaction(String transactionId, String accountId, double amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return transactionId + " | Acc: " + accountId + " | Amount: " + amount;
    }
}

public class BankingTransactionSystem {

    // 1. All transactions history
    private List<Transaction> transactionHistory = new ArrayList<>();

    // 2. Pending transactions queue
    private Queue<Transaction> transactionQueue = new LinkedList<>();

    // 3. Valid accounts set
    private Set<Account> accounts = new HashSet<>();

    // 4. Stack for rollback
    private Stack<Transaction> transactionStack = new Stack<>();

    // Add account
    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    // Find account
    private Account getAccount(String accountId) {
        for (Account acc : accounts) {
            if (acc.accountId.equals(accountId)) {
                return acc;
            }
        }
        return null;
    }

    // 1. Add transaction to queue
    public void addTransaction(Transaction t) {
        transactionQueue.offer(t);
        System.out.println("Transaction Added: " + t);
    }

    // 3. Execute transactions sequentially
    public void processTransactions() {
        while (!transactionQueue.isEmpty()) {
            Transaction t = transactionQueue.poll();

            // 2. Validate account
            Account acc = getAccount(t.accountId);

            if (acc == null) {
                System.out.println("Invalid Account! Skipping: " + t);
                continue;
            }

            // Process transaction
            acc.balance += t.amount;

            // Store in history
            transactionHistory.add(t);

            // Push to stack for rollback
            transactionStack.push(t);

            System.out.println("Processed: " + t);
            System.out.println("Updated Account: " + acc);
        }
    }

    // 4. Rollback last transaction
    public void rollbackLastTransaction() {
        if (transactionStack.isEmpty()) {
            System.out.println("No transactions to rollback.");
            return;
        }

        Transaction last = transactionStack.pop();
        Account acc = getAccount(last.accountId);

        if (acc != null) {
            // Reverse the transaction
            acc.balance -= last.amount;

            transactionHistory.remove(last);

            System.out.println("Rolled Back: " + last);
            System.out.println("Updated Account: " + acc);
        }
    }

    // Show all transactions
    public void showTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }

    // Main method
    public static void main(String[] args) {
        BankingTransactionSystem system = new BankingTransactionSystem();

        // Add accounts
        system.addAccount(new Account("A101", "Amit", 1000));
        system.addAccount(new Account("A102", "Riya", 2000));

        // Add transactions
        system.addTransaction(new Transaction("T1", "A101", 500));   // deposit
        system.addTransaction(new Transaction("T2", "A102", -300));  // withdraw
        system.addTransaction(new Transaction("T3", "A999", 100));   // invalid

        // Process transactions
        system.processTransactions();

        // Show history
        system.showTransactionHistory();

        // Rollback last transaction
        system.rollbackLastTransaction();

        // Show history after rollback
        system.showTransactionHistory();
    }
}

