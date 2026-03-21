package com.gla.markerinterface;
interface SensitiveData {
    // Marker interface, no methods
}

class BankAccount implements SensitiveData {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{accountNumber='" + accountNumber + "', balance=" + balance + "}";
    }
}

class SensitiveDataTagging {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234567890", 5000.0);

        // Check for marker interface before encrypting
        if (account instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data: " + account);
        } else {
            System.out.println("No encryption needed: " + account);
        }
    }
}


