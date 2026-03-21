package com.gla.staticmethod;
interface SecurityUtils {
    // Static method to validate password
    static boolean isStrongPassword(String password) {
        // Password policy: min 8 chars, at least one uppercase, one digit, one special char
        if (password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*\\d.*")) return false;
        if (!password.matches(".*[!@#$%^&*()].*")) return false;
        return true;
    }
}

public class PasswordValidator {
    public static void main(String[] args) {
        String password = "MyPass@123";

        if (SecurityUtils.isStrongPassword(password)) {
            System.out.println("Password is strong.");
        } else {
            System.out.println("Password is weak.");
        }
    }
}

