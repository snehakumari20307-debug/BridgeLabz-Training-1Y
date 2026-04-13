package com.gla.Collection;
import java.util.*;

// Ride Request class
class RideRequest implements Comparable<RideRequest> {
    String requestId;
    String customerName;
    int priority; // higher value = higher priority

    public RideRequest(String requestId, String customerName, int priority) {
        this.requestId = requestId;
        this.customerName = customerName;
        this.priority = priority;
    }

    @Override
    public int compareTo(RideRequest other) {
        return other.priority - this.priority; // max-heap behavior
    }

    @Override
    public String toString() {
        return requestId + " (" + customerName + ", Priority: " + priority + ")";
    }
}

// Driver class
class Driver {
    String driverId;
    String name;

    public Driver(String driverId, String name) {
        this.driverId = driverId;
        this.name = name;
    }

    @Override
    public String toString() {
        return driverId + " - " + name;
    }

    // Important for Set (avoid duplicates)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver d = (Driver) o;
        return driverId.equals(d.driverId);
    }

    @Override
    public int hashCode() {
        return driverId.hashCode();
    }
}

// Ride class (completed ride)
class Ride {
    RideRequest request;
    Driver driver;

    public Ride(RideRequest request, Driver driver) {
        this.request = request;
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Ride: " + request + " -> Driver: " + driver;
    }
}

public class RideSharingDispatch {

    // 1. FIFO queue for incoming requests
    private Queue<RideRequest> requestQueue = new LinkedList<>();

    // 2. Priority queue for urgent/proximity-based assignment
    private PriorityQueue<RideRequest> priorityQueue = new PriorityQueue<>();

    // 3. Available drivers (no duplicates)
    private Set<Driver> availableDrivers = new HashSet<>();

    // 4. Completed rides
    private List<Ride> completedRides = new ArrayList<>();

    // Add ride request
    public void addRideRequest(RideRequest request) {
        requestQueue.offer(request);
        priorityQueue.offer(request);
        System.out.println("Added Request: " + request);
    }

    // Add driver
    public void addDriver(Driver driver) {
        if (availableDrivers.add(driver)) {
            System.out.println("Driver Available: " + driver);
        } else {
            System.out.println("Duplicate Driver Ignored: " + driver.driverId);
        }
    }

    // Assign ride based on priority
    public void assignRide() {
        if (priorityQueue.isEmpty()) {
            System.out.println("No ride requests available.");
            return;
        }

        if (availableDrivers.isEmpty()) {
            System.out.println("No drivers available.");
            return;
        }

        // Get highest priority request
        RideRequest request = priorityQueue.poll();

        // Remove from normal queue as well
        requestQueue.remove(request);

        // Get any available driver
        Driver driver = availableDrivers.iterator().next();
        availableDrivers.remove(driver);

        System.out.println("Assigned Driver " + driver + " to Request " + request);

        // Simulate ride completion
        completeRide(request, driver);
    }

    // Complete ride
    public void completeRide(RideRequest request, Driver driver) {
        Ride ride = new Ride(request, driver);
        completedRides.add(ride);

        // Driver becomes available again
        availableDrivers.add(driver);

        System.out.println("Completed: " + ride);
    }

    // Show ride history
    public void showCompletedRides() {
        System.out.println("\n--- Completed Rides ---");
        for (Ride r : completedRides) {
            System.out.println(r);
        }
    }

    // Main method
    public static void main(String[] args) {
        RideSharingDispatch system = new RideSharingDispatch();

        // Add drivers
        system.addDriver(new Driver("D1", "Rahul"));
        system.addDriver(new Driver("D2", "Sneha"));
        system.addDriver(new Driver("D1", "Duplicate")); // duplicate

        // Add ride requests
        system.addRideRequest(new RideRequest("R1", "Amit", 2));
        system.addRideRequest(new RideRequest("R2", "Neha", 5)); // high priority
        system.addRideRequest(new RideRequest("R3", "Raj", 1));

        // Assign rides
        system.assignRide();
        system.assignRide();
        system.assignRide();

        // Show completed rides
        system.showCompletedRides();
    }
}

