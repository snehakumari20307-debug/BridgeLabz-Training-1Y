package com.gla.classes.Level2;

// PalindromeChecker.java
class PalindromeString {
    // Attribute to store the text
    String text;

    // Constructor to initialize the text
    public PalindromeString(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase(); // remove spaces and ignore case
        int left = 0;
        int right = cleanedText.length() - 1;

        while (left < right) {
            if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to display the result
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }

    // Main method to test the PalindromeChecker class
    public static void main(String[] args) {
        PalindromeString pc1 = new PalindromeString("Madam");
        pc1.displayResult();

        PalindromeString pc2 = new PalindromeString("Hello World");
        pc2.displayResult();

        PalindromeString pc3 = new PalindromeString("A man a plan a canal Panama");
        pc3.displayResult();
    }
}
