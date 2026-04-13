package com.gla.Collection;
import java.util.*;

// Booking class
class Booking implements Comparable<Booking> {
    String bookingId;
    String userId;
    String eventName;
    boolean isVIP;

    public Booking(String bookingId, String userId, String eventName, boolean isVIP) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.eventName = eventName;
        this.isVIP = isVIP;
    }

    @Override
    public String toString() {
        return bookingId + " | User: " + userId +
                " | Event: " + eventName +
                " | VIP: " + isVIP;
    }

    // VIP priority (VIP first)
    @Override
    public int compareTo(Booking other) {
        if (this.isVIP == other.isVIP) return 0;
        return this.isVIP ? -1 : 1;
    }
}

public class EventTicketReservation {

    // 1. All confirmed bookings
    private List<Booking> confirmedBookings = new ArrayList<>();

    // 2. Unique users
    private Set<String> users = new HashSet<>();

    // 3. Normal queue (FIFO)
    private Queue<Booking> bookingQueue = new LinkedList<>();

    // 4. VIP priority queue
    private PriorityQueue<Booking> vipQueue = new PriorityQueue<>();

    // Register user
    public void registerUser(String userId) {
        if (users.add(userId)) {
            System.out.println("User Registered: " + userId);
        } else {
            System.out.println("Duplicate User! " + userId);
        }
    }

    // Add booking request
    public void addBooking(Booking booking) {
        if (!users.contains(booking.userId)) {
            System.out.println("User not registered: " + booking.userId);
            return;
        }

        bookingQueue.offer(booking);
        vipQueue.offer(booking);

        System.out.println("Booking Requested: " + booking);
    }

    // Process bookings (VIP first)
    public void processBookings() {
        while (!vipQueue.isEmpty()) {
            Booking b = vipQueue.poll();

            // Remove from normal queue as well
            bookingQueue.remove(b);

            confirmBooking(b);
        }
    }

    // Confirm booking
    private void confirmBooking(Booking booking) {
        confirmedBookings.add(booking);
        System.out.println("Booking Confirmed: " + booking);
    }

    // Show all confirmed bookings
    public void showBookings() {
        System.out.println("\n--- Confirmed Bookings ---");
        for (Booking b : confirmedBookings) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        EventTicketReservation system = new EventTicketReservation();

        // Register users
        system.registerUser("U1");
        system.registerUser("U2");
        system.registerUser("U1"); // duplicate

        // Add bookings
        system.addBooking(new Booking("B1", "U1", "Concert", false));
        system.addBooking(new Booking("B2", "U2", "Concert", true)); // VIP
        system.addBooking(new Booking("B3", "U3", "Concert", false)); // not registered

        // Process bookings
        system.processBookings();

        // Show results
        system.showBookings();
    }
}

