package com.gla.encapsulation;

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Class
abstract class Product {
    // Encapsulation (private fields)
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters & Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract Method
    abstract double calculateDiscount();

    // Display Method
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Base Price: " + price);
    }
}

// Electronics Class
class Electronics extends Product implements Taxable {

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18% GST";
    }
}

// Clothing Class
class Clothing extends Product implements Taxable {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5% GST";
    }
}

// Groceries Class (No Tax)
class Groceries extends Product {

    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Utility Class to demonstrate Polymorphism
class PriceCalculator {

    public static void calculateFinalPrice(Product[] products) {
        for (Product product : products) {
            product.displayDetails();

            double price = product.getPrice();
            double discount = product.calculateDiscount();

            double tax = 0;
            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                tax = taxableProduct.calculateTax();
                System.out.println(taxableProduct.getTaxDetails());
            } else {
                System.out.println("No Tax Applicable");
            }

            double finalPrice = price + tax - discount;

            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-----------------------------");
        }
    }
}

// Main Class
public class ECommercePlatform {
    public static void main(String[] args) {

        // Polymorphism
        Product p1 = new Electronics(1, "Laptop", 50000);
        Product p2 = new Clothing(2, "T-Shirt", 2000);
        Product p3 = new Groceries(3, "Rice Bag", 1000);

        Product[] products = {p1, p2, p3};

        PriceCalculator.calculateFinalPrice(products);
    }
}
