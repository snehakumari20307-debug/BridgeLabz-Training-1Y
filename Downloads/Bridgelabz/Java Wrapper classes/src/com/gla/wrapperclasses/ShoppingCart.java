package com.gla.wrapperclasses;

public class ShoppingCart {

    public static void main(String[] args) {

        // Prices stored as strings
        String[] prices = {"250", "499", "99", "abc", "150"};

        Integer total = 0;  // Wrapper class

        for (String price : prices) {
            try {

                Integer value = Integer.parseInt(price);


                total = total + value;

            } catch (NumberFormatException e) {

                System.out.println("Invalid price skipped: " + price);
            }
        }

        System.out.println("Total price: " + total);
    }
}
