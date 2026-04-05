package com.gla.wrapperclasses;
public class BankTransaction {

    // Method to calculate remaining limit
    public static double getRemainingLimit(Double dailyLimit, double amountWithdrawn) {
        // Handle null limit
        if (dailyLimit == null) {
            return 0.0;
        }

        // Autounboxing happens here: Double -> double
        double remaining = dailyLimit - amountWithdrawn;

        // Ensure remaining limit is not negative
        return remaining >= 0 ? remaining : 0.0;
    }

    public static void main(String[] args) {
        // Example usage

        // New account with Double object
        Double newAccountLimit = 1000.0;
        double withdrawn1 = 250.0;
        System.out.println("Remaining limit (new account): " + getRemainingLimit(newAccountLimit, withdrawn1));

        // Old account with primitive double
        double oldAccountLimit = 500.0;
        double withdrawn2 = 600.0;
        System.out.println("Remaining limit (old account): " + getRemainingLimit(oldAccountLimit, withdrawn2));

        // Account with null limit
        Double nullLimitAccount = null;
        double withdrawn3 = 100.0;
        System.out.println("Remaining limit (null limit): " + getRemainingLimit(nullLimitAccount, withdrawn3));
    }
}

