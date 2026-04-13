package com.gla.Collection;
import java.util.*;
class Book {
    String title;
    boolean isIssued;

    public Book(String title) {
        this.title = title;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return title + " | Issued: " + isIssued;
    }
}


 class LibrarySystem {

    // 1. All books
    private List<Book> bookList = new ArrayList<>();

    // 2. Unique members
    private Set<String> memberSet = new HashSet<>();

    // 3. Queue for issuing books
    private Queue<Book> issueQueue = new LinkedList<>();

    // 4. Recently returned books
    private Stack<Book> returnStack = new Stack<>();

    // -------------------------------
    // 1. Add Book
    // -------------------------------
    public void addBook(String title) {
        bookList.add(new Book(title));
        System.out.println("Book added: " + title);
    }

    // -------------------------------
    // Register Member
    // -------------------------------
    public void registerMember(String memberId) {
        if (memberSet.add(memberId)) {
            System.out.println("Member registered: " + memberId);
        } else {
            System.out.println("Duplicate member ignored: " + memberId);
        }
    }

    // -------------------------------
    // 2. Issue Book
    // -------------------------------
    public void requestBook(String title) {
        for (Book b : bookList) {
            if (b.title.equals(title) && !b.isIssued) {
                issueQueue.add(b);
                System.out.println("Book added to issue queue: " + title);
                return;
            }
        }
        System.out.println("Book not available: " + title);
    }

    public void issueBook() {
        if (issueQueue.isEmpty()) {
            System.out.println("No books in issue queue.");
            return;
        }

        Book b = issueQueue.poll();
        b.isIssued = true;

        System.out.println("Book issued: " + b.title);
    }

    // -------------------------------
    // Return Book
    // -------------------------------
    public void returnBook(String title) {
        for (Book b : bookList) {
            if (b.title.equals(title) && b.isIssued) {
                b.isIssued = false;
                returnStack.push(b);
                System.out.println("Book returned: " + title);
                return;
            }
        }
        System.out.println("Invalid return: " + title);
    }

    // -------------------------------
    // 4. Re-issue Last Returned Book
    // -------------------------------
    public void reissueLastReturned() {
        if (returnStack.isEmpty()) {
            System.out.println("No recently returned books.");
            return;
        }

        Book b = returnStack.pop();
        if (!b.isIssued) {
            b.isIssued = true;
            System.out.println("Re-issued book: " + b.title);
        }
    }

    // -------------------------------
    // Show Library Status
    // -------------------------------
    public void showStatus() {
        System.out.println("\nAll Books:");
        for (Book b : bookList) {
            System.out.println(b);
        }

        System.out.println("\nRegistered Members:");
        for (String m : memberSet) {
            System.out.println(m);
        }

        System.out.println("\nIssue Queue:");
        for (Book b : issueQueue) {
            System.out.println(b.title);
        }

        System.out.println("\nRecently Returned:");
        for (Book b : returnStack) {
            System.out.println(b.title);
        }
    }
}
public class LibraryManagement {
    public static void main(String[] args) {

        LibrarySystem lib = new LibrarySystem();

        // Add books
        lib.addBook("Java Programming");
        lib.addBook("Data Structures");
        lib.addBook("Algorithms");

        // Register members
        lib.registerMember("M1");
        lib.registerMember("M2");
        lib.registerMember("M1"); // duplicate

        // Request & issue books
        lib.requestBook("Java Programming");
        lib.requestBook("Data Structures");
        lib.issueBook();
        lib.issueBook();

        // Return book
        lib.returnBook("Java Programming");

        // Re-issue last returned
        lib.reissueLastReturned();

        // Show status
        lib.showStatus();
    }
}
