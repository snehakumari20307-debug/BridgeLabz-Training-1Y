package com.gla.MapInterface;
import java.util.*;

public class ProductPriceSummary {

    // Product -> Price (in insertion order)
    private LinkedHashMap<String, Double> cart = new LinkedHashMap<>();

    // 1. Add product
    public void addProduct(String name, double price) {
        cart.put(name, price);
        System.out.println("Added: " + name + " -> ₹" + price);
    }

    // 5. Remove product (simulate quantity = 0)
    public void removeProduct(String name) {
        if (cart.remove(name) != null) {
            System.out.println("Removed: " + name);
        } else {
            System.out.println("Product not found: " + name);
        }
    }

    // 2. Display products in insertion order
    public void displayCart() {
        System.out.println("\n--- Cart Items (Insertion Order) ---");

        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> ₹" + entry.getValue());
        }
    }

    // 3 & 4. Calculate total + discount
    public void calculateBill() {

        double total = 0;

        for (double price : cart.values()) {
            total += price;
        }

        System.out.println("\nTotal Bill Before Discount: ₹" + total);

        // 4. Apply discount if total > 5000
        if (total > 5000) {
            double discount = total * 0.10;
            total -= discount;

            System.out.println("10% Discount Applied: -₹" + discount);
        }

        System.out.println("Final Payable Amount: ₹" + total);
    }

    public static void main(String[] args) {

        ProductPriceSummary cart = new ProductPriceSummary();

        // 1. Add products
        cart.addProduct("Laptop", 45000);
        cart.addProduct("Mouse", 800);
        cart.addProduct("Keyboard", 1500);
        cart.addProduct("Headphones", 2000);
        cart.addProduct("USB Cable", 300);

        // 5. Remove item (simulate quantity = 0)
        cart.removeProduct("USB Cable");

        // 2. Display cart
        cart.displayCart();

        // 3 & 4. Calculate bill
        cart.calculateBill();
    }
}
