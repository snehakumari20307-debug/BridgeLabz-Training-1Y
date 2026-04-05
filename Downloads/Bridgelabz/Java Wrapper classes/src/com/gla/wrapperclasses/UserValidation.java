package com.gla.wrapperclasses;

public class UserValidation {

    public static boolean isValidAge(String ageStr) {
        try {
            // Convert String to Integer using wrapper class
            Integer age = Integer.valueOf(ageStr);

            // Check if age is 18 or older
            return age >= 18;

        } catch (NumberFormatException e) {
            // If conversion fails, it's not a valid integer
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidAge("20"));  // true
        System.out.println(isValidAge("17"));  // false
        System.out.println(isValidAge("abc")); // false
    }
}
