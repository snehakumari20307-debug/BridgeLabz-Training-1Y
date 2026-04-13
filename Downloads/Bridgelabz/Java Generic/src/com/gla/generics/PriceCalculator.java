package com.gla.generics;

import java.util.*;

// Superclass Product
class Product {
    double price;

    public Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// Mobile class
class Mobile extends Product {
    String name;

    public Mobile(String name, double price) {
        super(price);
        this.name = name;
    }

    public String toString() {
        return "Mobile: " + name + " Price: " + price;
    }
}

// Laptop class
class Laptop extends Product {
    String name;

    public Laptop(String name, double price) {
        super(price);
        this.name = name;
    }

    public String toString() {
        return "Laptop: " + name + " Price: " + price;
    }
}
public class PriceCalculator{

    // Generic method to calculate total price
    public static double calculateTotal(List<? extends Product> items) {
        double total = 0;

        for (Product item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public static void main(String[] args) {

        // List of Mobile products
        List<Mobile> mobiles = Arrays.asList(
                new Mobile("iPhone", 80000),
                new Mobile("Samsung", 60000)
        );

        // List of Laptop products
        List<Laptop> laptops = Arrays.asList(
                new Laptop("Dell", 70000),
                new Laptop("HP", 65000)
        );

        // Calculate totals
        System.out.println("Total Mobile Price: " + calculateTotal(mobiles));
        System.out.println("Total Laptop Price: " + calculateTotal(laptops));
    }
}
