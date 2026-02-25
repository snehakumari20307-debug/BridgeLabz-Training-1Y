package com.gla.classes.Level2;
// MovieTicket.java
class MovieTicketBooking {
    // Attributes
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;

    // Constructor to initialize the movie ticket
    public MovieTicketBooking(String movieName) {
        this.movieName = movieName;
        this.seatNumber = "";
        this.price = 0.0;
        this.isBooked = false;
    }

    // Method to book a ticket by assigning seat number and price
    public void bookTicketBooking(String seatNumber, double price) {
        if (!isBooked) {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket successfully booked for seat " + seatNumber);
        } else {
            System.out.println("Sorry, this ticket has already been booked.");
        }
    }

    // Method to display ticket details
    public void displayTicketDetails() {
        System.out.println("Movie Ticket Details:");
        System.out.println("Movie Name: " + movieName);
        if (isBooked) {
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("Ticket not booked yet.");
        }
        System.out.println("---------------------------");
    }

    // Main method to test the MovieTicket class
    public static void main(String[] args) {
        // Creating a MovieTicket object
        MovieTicketBooking ticket1 = new MovieTicketBooking("Inception");

        // Display details before booking
        ticket1.displayTicketDetails();

        // Book a ticket
        ticket1.bookTicketBooking("A10", 12.50);

        // Display details after booking
        ticket1.displayTicketDetails();

        // Attempt to book the same ticket again
        ticket1.bookTicketBooking("A11", 12.50);
    }
}
