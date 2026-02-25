package com.gla.classes.Level1;

// Item.java
class InventoryOfItems{
    // Attributes
    String itemCode;
    String itemName;
    double price;

    // Constructor to initialize item
    public InventoryOfItems(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to calculate total cost for a given quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    // Method to display item details
    public void displayDetails() {
        System.out.println("Item Details:");
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per unit: $" + price);
    }

    // Main method to test the Item class
    public static void main(String[] args) {
        // Creating an Item object
        InventoryOfItems item1 = new InventoryOfItems("A101", "Laptop", 750.50);

        // Display item details
        item1.displayDetails();

        // Calculate total cost for 3 items
        int quantity = 3;
        double totalCost = item1.calculateTotalCost(quantity);
        System.out.println("Total cost for " + quantity + " items: $" + totalCost);
    }
}
