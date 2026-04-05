package com.gla.wrapperclasses;
public class ShoppingCartCalculator {
    public static void main(String[] args) {

        // Prices stored as Strings
        String[] prices = {"250", "499", "99", "abc", "150"};

        // Using Integer wrapper class for total
        Integer totalPrice = 0;

        for (String price : prices) {
            try {
                // Convert String to Integer (Wrapper class usage)
                Integer numericPrice = Integer.parseInt(price);

                // Add to total (auto-unboxing happens here)
                totalPrice = totalPrice + numericPrice;

            } catch (NumberFormatException e) {
                // Handle invalid input
                System.out.println("Invalid price skipped: " + price);
            }
        }

        // Display total
        System.out.println("Total Price: " + totalPrice);
    }
}

