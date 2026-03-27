package com.gla.thread;
class Order implements Runnable {

    private int orderId;
    private String restaurantName;
    private int deliveryTime; // in seconds

    public Order(int orderId, String restaurantName, int deliveryTime) {
        this.orderId = orderId;
        this.restaurantName = restaurantName;
        this.deliveryTime = deliveryTime;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        long startTime = System.currentTimeMillis();

        try {
            System.out.println("Order " + orderId + " from " + restaurantName +
                    " | Agent: " + t.getName() +
                    " | Status: Picked up");

            Thread.sleep(1000);

            System.out.println("Order " + orderId +
                    " | Agent: " + t.getName() +
                    " | Status: In Transit");

            Thread.sleep(deliveryTime * 1000);

            System.out.println("Order " + orderId +
                    " | Agent: " + t.getName() +
                    " | Status: Delivered");

            long endTime = System.currentTimeMillis();
            long totalTime = (endTime - startTime) / 1000;

            System.out.println("Order " + orderId +
                    " completed in " + totalTime + " seconds\n");

        } catch (InterruptedException e) {
            System.out.println("Order " + orderId + " interrupted");
        }
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {

        // Creating orders
        Order o1 = new Order(101, "Pizza Hut", 5);   // Express
        Order o2 = new Order(102, "Dominos", 7);     // Standard
        Order o3 = new Order(103, "KFC", 6);         // Economy
        Order o4 = new Order(104, "Burger King", 4); // Express
        Order o5 = new Order(105, "Subway", 8);      // Standard

        // Creating threads (Delivery Agents)
        Thread t1 = new Thread(o1, "Agent-1");
        Thread t2 = new Thread(o2, "Agent-2");
        Thread t3 = new Thread(o3, "Agent-3");
        Thread t4 = new Thread(o4, "Agent-4");
        Thread t5 = new Thread(o5, "Agent-5");

        // Setting priorities
        t1.setPriority(10); // Express
        t4.setPriority(10); // Express

        t2.setPriority(5);  // Standard
        t5.setPriority(5);  // Standard

        t3.setPriority(3);  // Economy

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Wait for all deliveries to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\nAll orders have been delivered!");
    }
}
