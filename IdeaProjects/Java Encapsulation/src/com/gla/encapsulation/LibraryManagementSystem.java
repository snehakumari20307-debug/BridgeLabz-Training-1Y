package com.gla.encapsulation;

// Interface
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract Class
abstract class LibraryItem {
    // Encapsulation (private fields)
    private int itemId;
    private String title;
    private String author;

    // Sensitive data (borrower info)
    private String borrowerName;
    private boolean isAvailable = true;

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters & Setters
    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    protected String getMaskedBorrower() {
        if (borrowerName == null) return "None";
        return borrowerName.charAt(0) + "***";
    }

    protected boolean isAvailable() {
        return isAvailable;
    }

    protected void setAvailability(boolean status) {
        this.isAvailable = status;
    }

    // Abstract method
    abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
        System.out.println("Borrower: " + getMaskedBorrower());
    }
}

// Book Class
class Book extends LibraryItem implements Reservable {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    int getLoanDuration() {
        return 14; // 14 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrowerName(borrowerName);
            setAvailability(false);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book not available.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine Class
class Magazine extends LibraryItem implements Reservable {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    int getLoanDuration() {
        return 7; // 7 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrowerName(borrowerName);
            setAvailability(false);
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine not available.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// DVD Class
class DVD extends LibraryItem implements Reservable {

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    int getLoanDuration() {
        return 5; // 5 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrowerName(borrowerName);
            setAvailability(false);
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD not available.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Utility class for polymorphism
class LibraryManager {

    public static void processItems(LibraryItem[] items) {
        for (LibraryItem item : items) {
            item.getItemDetails();

            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // Interface usage
            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                System.out.println("Available for reservation: " + r.checkAvailability());
            }

            System.out.println("---------------------------");
        }
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {

        // Polymorphism
        LibraryItem b1 = new Book(1, "Java Programming", "James Gosling");
        LibraryItem m1 = new Magazine(2, "Tech Today", "Editorial Team");
        LibraryItem d1 = new DVD(3, "Inception", "Christopher Nolan");

        // Reserve one item
        ((Reservable) b1).reserveItem("Rahul");

        LibraryItem[] items = {b1, m1, d1};

        LibraryManager.processItems(items);
    }
}
