package com.gla.Collection;
import java.util.*;
class Parcel implements Comparable<Parcel> {
    String deliveryId;
    String address;
    int priority; // higher = more urgent

    public Parcel(String deliveryId, String address, int priority) {
        this.deliveryId = deliveryId;
        this.address = address;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return deliveryId + " | " + address + " | Priority: " + priority;
    }

    // PriorityQueue sorting (higher priority first)
    @Override
    public int compareTo(Parcel other) {
        return Integer.compare(other.priority, this.priority);
    }
}


 class CourierSystem {

    // 1. Unique delivery IDs
    private Set<String> deliveryIds = new HashSet<>();

    // 2. High-priority parcels
    private PriorityQueue<Parcel> priorityQueue = new PriorityQueue<>();

    // 3. Normal pending parcels
    private Queue<Parcel> normalQueue = new LinkedList<>();

    // 4. Completed deliveries
    private List<Parcel> completedList = new ArrayList<>();

    // -------------------------------
    // 1. Add Parcel
    // -------------------------------
    public void addParcel(String id, String address, int priority) {
        if (!deliveryIds.add(id)) {
            System.out.println("Duplicate parcel ignored: " + id);
            return;
        }

        Parcel p = new Parcel(id, address, priority);

        if (priority >= 5) {
            priorityQueue.add(p);
            System.out.println("Added to PRIORITY queue: " + p);
        } else {
            normalQueue.add(p);
            System.out.println("Added to NORMAL queue: " + p);
        }
    }

    // -------------------------------
    // 2. Assign Delivery Agent (Simulated)
    // -------------------------------
    public void assignDeliveryAgent() {
        Parcel p = null;

        // Priority first
        if (!priorityQueue.isEmpty()) {
            p = priorityQueue.poll();
        }
        // Then normal queue
        else if (!normalQueue.isEmpty()) {
            p = normalQueue.poll();
        }

        if (p == null) {
            System.out.println("No parcels to deliver.");
            return;
        }

        System.out.println("Assigned agent to: " + p);

        // Simulate delivery completion
        completeDelivery(p);
    }

    // -------------------------------
    // 3. Complete Delivery
    // -------------------------------
    private void completeDelivery(Parcel p) {
        completedList.add(p);
        System.out.println("Delivery completed: " + p);
    }

    // -------------------------------
    // 4. Show Completed Deliveries
    // -------------------------------
    public void showCompleted() {
        System.out.println("\nCompleted Deliveries:");
        for (Parcel p : completedList) {
            System.out.println(p);
        }
    }
}
public class CourierDeliveryRouting {
    public static void main(String[] args) {

        CourierSystem system = new CourierSystem();

        // Add parcels
        system.addParcel("D101", "Delhi", 8);   // high priority
        system.addParcel("D102", "Mumbai", 3);  // normal
        system.addParcel("D103", "Chennai", 6); // high priority
        system.addParcel("D101", "Kolkata", 2); // duplicate

        // Assign deliveries
        system.assignDeliveryAgent();
        system.assignDeliveryAgent();
        system.assignDeliveryAgent();

        // Show completed deliveries
        system.showCompleted();
    }
}
