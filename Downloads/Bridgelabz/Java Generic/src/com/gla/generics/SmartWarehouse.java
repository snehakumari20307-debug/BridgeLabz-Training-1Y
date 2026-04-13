package com.gla.generics;
import java.util.*;

public class SmartWarehouse {

    // Abstract base class
    static abstract class WarehouseItem {
        String name;
        double price;

        public WarehouseItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public abstract void display();
    }

    // Electronics
    static class Electronics extends WarehouseItem {
        public Electronics(String name, double price) {
            super(name, price);
        }

        public void display() {
            System.out.println("Electronics: " + name + " | Price: " + price);
        }
    }

    // Groceries
    static class Groceries extends WarehouseItem {
        public Groceries(String name, double price) {
            super(name, price);
        }

        public void display() {
            System.out.println("Groceries: " + name + " | Price: " + price);
        }
    }

    // Furniture
    static class Furniture extends WarehouseItem {
        public Furniture(String name, double price) {
            super(name, price);
        }

        public void display() {
            System.out.println("Furniture: " + name + " | Price: " + price);
        }
    }

    // Generic Storage class
    static class Storage<T extends WarehouseItem> {
        private List<T> items = new ArrayList<>();

        public void addItem(T item) {
            items.add(item);
        }

        public List<T> getItems() {
            return items;
        }

        // Wildcard method
        public static void displayAll(List<? extends WarehouseItem> items) {
            for (WarehouseItem item : items) {
                item.display();
            }
        }
    }

    public static void main(String[] args) {

        // Electronics storage
        Storage<Electronics> electronics = new Storage<>();
        electronics.addItem(new Electronics("Laptop", 80000));
        electronics.addItem(new Electronics("Mobile", 50000));

        // Groceries storage
        Storage<Groceries> groceries = new Storage<>();
        groceries.addItem(new Groceries("Rice", 100));
        groceries.addItem(new Groceries("Milk", 60));

        // Furniture storage
        Storage<Furniture> furniture = new Storage<>();
        furniture.addItem(new Furniture("Chair", 2000));
        furniture.addItem(new Furniture("Table", 5000));

        System.out.println("📦 Electronics:");
        Storage.displayAll(electronics.getItems());

        System.out.println("\n🛒 Groceries:");
        Storage.displayAll(groceries.getItems());

        System.out.println("\n🪑 Furniture:");
        Storage.displayAll(furniture.getItems());
    }
}

