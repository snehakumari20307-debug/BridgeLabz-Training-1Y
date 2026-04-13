package com.gla.generics;
import java.util.*;

public class DynamicOnlineMarketplace{


    static class Product<T> {
        String name;
        double price;
        T category;

        public Product(String name, double price, T category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public void display() {
            System.out.println(name + " | Price: " + price + " | Category: " + category);
        }
    }

    enum BookCategory {
        FICTION, EDUCATION, HISTORY
    }

    enum ClothingCategory {
        MEN, WOMEN, KIDS
    }

    enum GadgetCategory {
        MOBILE, LAPTOP, ACCESSORIES
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.price * (percentage / 100);
        product.price = product.price - discount;
    }

    public static void main(String[] args) {


        Product<BookCategory> book1 =
                new Product<>("Java Programming", 500, BookCategory.EDUCATION);

        Product<BookCategory> book2 =
                new Product<>("Harry Potter", 800, BookCategory.FICTION);


        Product<ClothingCategory> cloth1 =
                new Product<>("T-Shirt", 300, ClothingCategory.MEN);

        Product<ClothingCategory> cloth2 =
                new Product<>("Dress", 1200, ClothingCategory.WOMEN);


        Product<GadgetCategory> gadget1 =
                new Product<>("iPhone", 80000, GadgetCategory.MOBILE);

        Product<GadgetCategory> gadget2 =
                new Product<>("Laptop", 60000, GadgetCategory.LAPTOP);


        System.out.println("📦 BEFORE DISCOUNT:");
        book1.display();
        cloth1.display();
        gadget1.display();

        applyDiscount(book1, 10);
        applyDiscount(cloth1, 20);
        applyDiscount(gadget1, 5);

        System.out.println("\n💰 AFTER DISCOUNT:");
        book1.display();
        cloth1.display();
        gadget1.display();
    }
}
