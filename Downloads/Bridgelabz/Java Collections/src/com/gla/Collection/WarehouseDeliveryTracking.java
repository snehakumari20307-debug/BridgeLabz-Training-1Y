package com.gla.Collection;
import java.util.*;

// Package class
class PackageItem {
    String packageId;
    String customerName;
    String address;

    public PackageItem(String packageId, String customerName, String address) {
        this.packageId = packageId;
        this.customerName = customerName;
        this.address = address;
    }

    @Override
    public String toString() {
        return packageId + " | " + customerName + " | " + address;
    }
}

public class WarehouseDeliveryTracking {

    // 1. Pending deliveries (FIFO)
    private Queue<PackageItem> deliveryQueue = new LinkedList<>();

    // 2. Unique package IDs
    private Set<String> packageIds = new HashSet<>();

    // 3. Delivered packages
    private List<PackageItem> deliveredPackages = new ArrayList<>();

    // 4. Returned/Cancelled packages (LIFO)
    private Stack<PackageItem> returnedStack = new Stack<>();

    // Add package (no duplicates)
    public void addPackage(PackageItem pkg) {
        if (packageIds.add(pkg.packageId)) {
            deliveryQueue.offer(pkg);
            System.out.println("Package Added: " + pkg);
        } else {
            System.out.println("Duplicate Package ID! Skipped: " + pkg.packageId);
        }
    }

    // Process delivery
    public void processDelivery(boolean isDelivered) {
        if (deliveryQueue.isEmpty()) {
            System.out.println("No pending deliveries.");
            return;
        }

        PackageItem pkg = deliveryQueue.poll();

        if (isDelivered) {
            deliveredPackages.add(pkg);
            System.out.println("Delivered: " + pkg);
        } else {
            returnedStack.push(pkg);
            System.out.println("Returned/Cancelled: " + pkg);
        }
    }

    // Show summary
    public void showSummary() {
        System.out.println("\n--- Delivery Summary ---");

        System.out.println("\nDelivered Packages:");
        for (PackageItem p : deliveredPackages) {
            System.out.println(p);
        }

        System.out.println("\nReturned/Cancelled Packages:");
        for (PackageItem p : returnedStack) {
            System.out.println(p);
        }

        System.out.println("\nPending Packages:");
        for (PackageItem p : deliveryQueue) {
            System.out.println(p);
        }
    }

    // Main method
    public static void main(String[] args) {
        WarehouseDeliveryTracking system = new WarehouseDeliveryTracking();

        // Add packages
        system.addPackage(new PackageItem("P101", "Amit", "Delhi"));
        system.addPackage(new PackageItem("P102", "Riya", "Mumbai"));
        system.addPackage(new PackageItem("P103", "Rahul", "Pune"));
        system.addPackage(new PackageItem("P101", "Duplicate", "Delhi")); // duplicate

        // Process deliveries
        system.processDelivery(true);   // delivered
        system.processDelivery(false);  // returned
        system.processDelivery(true);   // delivered

        // Show summary
        system.showSummary();
    }
}

