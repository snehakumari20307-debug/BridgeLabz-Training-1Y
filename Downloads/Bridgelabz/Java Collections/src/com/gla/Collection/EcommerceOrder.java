package com.gla.Collection;
import java.util.*;

// Order class
class Order {
    int orderId;
    String customerName;

    Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Order{" + orderId + ", " + customerName + "}";
    }

    // Important: define equality based on orderId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return false;
        Order other = (Order) obj;
        return this.orderId == other.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}

public class EcommerceOrder {

    public static void main(String[] args) {

        // 1. List of all orders (including duplicates)
        List<Order> allOrders = new ArrayList<>();

        allOrders.add(new Order(101, "Amit"));
        allOrders.add(new Order(102, "Ravi"));
        allOrders.add(new Order(103, "Neha"));
        allOrders.add(new Order(101, "Amit Duplicate")); // duplicate
        allOrders.add(new Order(104, "Sara"));

        System.out.println("All Orders: " + allOrders);

        // 2. Remove duplicates using Set
        Set<Order> uniqueOrders = new LinkedHashSet<>(allOrders);

        System.out.println("Unique Orders: " + uniqueOrders);

        // 3. Process orders using Queue (FIFO)
        Queue<Order> queue = new LinkedList<>(uniqueOrders);

        // Stack for failed orders
        Stack<Order> failedOrders = new Stack<>();

        System.out.println("\nProcessing Orders:");

        while (!queue.isEmpty()) {
            Order order = queue.remove();

            // Simulate processing (fail orderId 103 for demo)
            if (order.orderId == 103) {
                System.out.println("FAILED: " + order);
                failedOrders.push(order);
            } else {
                System.out.println("PROCESSED: " + order);
            }
        }

        // 4. Retry failed orders
        System.out.println("\nRetrying Failed Orders:");

        while (!failedOrders.isEmpty()) {
            Order order = failedOrders.pop();
            System.out.println("RETRY SUCCESS: " + order);
        }
    }
}

