package com.gla.LambdaExpression;
import java.util.*;

record Product(String name, double price, double rating, int discount) {}

public class EcommerceSorting {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Gaming Laptop", 1200.00, 4.5, 10),
                new Product("Wireless Mouse", 25.50, 4.2, 50),
                new Product("Mechanical Keyboard", 80.00, 4.8, 15),
                new Product("4K Monitor", 300.00, 4.6, 20)
        );

        // Define our sorting strategy based on a hypothetical campaign
        String campaignType = "DISCOUNT"; // Change to "PRICE" or "RATING"

        Comparator<Product> comparator = switch (campaignType) {
            case "PRICE"    -> Comparator.comparing(Product::price);
            case "RATING"   -> Comparator.comparing(Product::rating).reversed();
            case "DISCOUNT" -> Comparator.comparing(Product::discount).reversed();
            default         -> Comparator.comparing(Product::name);
        };

        // Apply sorting
        products.sort(comparator);

        // Display results
        System.out.println("Sorted by " + campaignType + ":");
        products.forEach(System.out::println);
    }
}

