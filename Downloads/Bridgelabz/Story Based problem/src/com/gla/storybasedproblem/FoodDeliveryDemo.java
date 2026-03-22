package com.gla.storybasedproblem;

class Order {
    protected int orderId;
    protected double baseAmount;
    protected static double deliveryCharge = 40; // common for all orders

    // Constructor
    public Order(int orderId, double baseAmount) {
        this.orderId = orderId;
        this.baseAmount = baseAmount;
    }

    // Method to calculate total bill (can be overridden)
    public double calculateBill() {
        return baseAmount + deliveryCharge; // default: no discount
    }

    // Display bill details
    public void displayBill() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Base Amount: $" + baseAmount);
        System.out.println("Delivery Charge: $" + deliveryCharge);
        System.out.println("Total Bill: $" + calculateBill());
        System.out.println("---------------------------");
    }
}

// RegularOrder subclass → no discount
class RegularOrder extends Order {
    public RegularOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    // No change in bill calculation
    @Override
    public double calculateBill() {
        return super.calculateBill();
    }
}

// PremiumOrder subclass → 20% discount
class PremiumOrder extends Order {
    public PremiumOrder(int orderId, double baseAmount) {
        super(orderId, baseAmount);
    }

    @Override
    public double calculateBill() {
        double discount = baseAmount * 0.20; // 20% discount
        return baseAmount - discount + deliveryCharge;
    }
}

// Demo class
public class FoodDeliveryDemo {
    public static void main(String[] args) {
        // Polymorphic array of orders
        Order[] orders = {
                new RegularOrder(101, 250),
                new PremiumOrder(102, 500),
                new RegularOrder(103, 120),
                new PremiumOrder(104, 800)
        };

        // Calculate and display bills using polymorphism
        for (Order o : orders) {
            o.displayBill();
        }
    }
}
