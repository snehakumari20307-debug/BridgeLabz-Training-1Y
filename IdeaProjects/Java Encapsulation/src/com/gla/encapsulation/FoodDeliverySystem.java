package com.gla.encapsulation;

// Interface for discounts
interface Discountable {
    void applyDiscount(double discountPercentage); // Apply discount
    String getDiscountDetails(); // Show discount info
}

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    protected double totalPrice;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = 0;
    }

    // Encapsulation: Getters and Setters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity must be positive.");
        }
    }

    // Concrete Method
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Unit: ₹" + price);
        System.out.println("Quantity: " + quantity);
    }

    // Abstract Method
    public abstract double calculateTotalPrice();
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    private double discountPercentage = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        totalPrice = getPrice() * getQuantity();
        // Apply discount if any
        if (discountPercentage > 0) {
            totalPrice = totalPrice - (totalPrice * discountPercentage / 100);
        }
        return totalPrice;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: " + discountPercentage + "%";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private double extraCharge = 20; // Extra charge per item
    private double discountPercentage = 0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        totalPrice = (getPrice() + extraCharge) * getQuantity();
        if (discountPercentage > 0) {
            totalPrice = totalPrice - (totalPrice * discountPercentage / 100);
        }
        return totalPrice;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: " + discountPercentage + "%";
    }
}

// Main class to demonstrate polymorphism
public class FoodDeliverySystem {

    public static void processOrder(FoodItem item) {
        item.getItemDetails();
        double total = item.calculateTotalPrice();
        System.out.println("Total Price: ₹" + total);

        // Show discount info if item is Discountable
        if (item instanceof Discountable) {
            System.out.println(((Discountable) item).getDiscountDetails());
        }
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        // Create Food Items
        FoodItem vegBurger = new VegItem("Veg Burger", 150, 2);
        FoodItem chickenPizza = new NonVegItem("Chicken Pizza", 250, 1);

        // Apply discounts
        ((Discountable) vegBurger).applyDiscount(10); // 10% off
        ((Discountable) chickenPizza).applyDiscount(5); // 5% off

        // Polymorphic order processing
        processOrder(vegBurger);
        processOrder(chickenPizza);
    }
}
