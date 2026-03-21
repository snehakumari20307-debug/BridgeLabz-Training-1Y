package com.gla.multilevelinheritance;
import java.time.LocalDate;

// Base class
class Order {
    protected int orderId;
    protected LocalDate orderDate;

    // Constructor
    public Order(int orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to return order status
    public String getOrderStatus() {
        return "Order Placed";
    }

    // Method to display order info
    public void displayOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

// Subclass representing shipped orders
class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(int orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped (Tracking: " + trackingNumber + ")";
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
    }
}

// Subclass representing delivered orders
class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;

    public DeliveredOrder(int orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
    }
}

// Demo class
public class OrderManagementDemo {
    public static void main(String[] args) {
        Order order1 = new Order(1001, LocalDate.of(2026, 3, 21));
        ShippedOrder order2 = new ShippedOrder(1002, LocalDate.of(2026, 3, 20), "TRK12345");
        DeliveredOrder order3 = new DeliveredOrder(1003, LocalDate.of(2026, 3, 18), "TRK67890", LocalDate.of(2026, 3, 21));

        // Polymorphic array of Orders
        Order[] orders = {order1, order2, order3};

        for (Order o : orders) {
            o.displayOrderInfo();
            System.out.println("---------------------------");
        }
    }
}

