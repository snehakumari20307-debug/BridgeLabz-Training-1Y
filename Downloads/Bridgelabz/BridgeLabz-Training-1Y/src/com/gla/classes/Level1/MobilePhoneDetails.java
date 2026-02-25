package com.gla.classes.Level1;
// MobilePhone.java
class MobilePhoneDetails {
    // Attributes
    String brand;
    String model;
    double price;

    // Constructor to initialize the mobile phone object
    public MobilePhoneDetails(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display all mobile phone details
    public void displayDetails() {
        System.out.println("Mobile Phone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
    }

    // Main method to test the MobilePhone class
    public static void main(String[] args) {
        // Creating a MobilePhone object
        MobilePhoneDetails phone1 = new MobilePhoneDetails("Apple", "iPhone 14", 999.99);

        // Displaying the details of the phone
        phone1.displayDetails();

        // Creating another MobilePhone object
        MobilePhoneDetails phone2 = new MobilePhoneDetails("Samsung", "Galaxy S23", 849.50);

        // Displaying the details of the second phone
        phone2.displayDetails();
    }
}

