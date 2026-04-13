package com.gla.generics;

    import java.util.*;

    public class GenericCart {

        // Generic Cart class
        static class Cart<T> {
            private List<T> items = new ArrayList<>();

            // Add item
            public void addItem(T item) {
                items.add(item);
            }

            // Remove item
            public void removeItem(T item) {
                items.remove(item);
            }

            // Display items
            public void displayItems() {
                if (items.isEmpty()) {
                    System.out.println("Cart is empty");
                    return;
                }

                for (T item : items) {
                    System.out.println(item);
                }
            }
        }

        // Electronics class
        static class Electronics {
            String name;

            public Electronics(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Electronics: " + name;
            }
        }

        // Clothing class
        static class Clothing {
            String name;

            public Clothing(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Clothing: " + name;
            }
        }

        public static void main(String[] args) {

            // Cart for Electronics only
            Cart<Electronics> electronicsCart = new Cart<>();
            electronicsCart.addItem(new Electronics("Laptop"));
            electronicsCart.addItem(new Electronics("Smartphone"));

            System.out.println("Electronics Cart:");
            electronicsCart.displayItems();

            System.out.println();

            // Cart for Clothing only
            Cart<Clothing> clothingCart = new Cart<>();
            clothingCart.addItem(new Clothing("T-Shirt"));
            clothingCart.addItem(new Clothing("Jeans"));

            System.out.println("Clothing Cart:");
            clothingCart.displayItems();


    }
}
