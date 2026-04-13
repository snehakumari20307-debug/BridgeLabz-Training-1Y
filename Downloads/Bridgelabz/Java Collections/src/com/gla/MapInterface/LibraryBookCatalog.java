package com.gla.MapInterface;
import java.util.*;

public class LibraryBookCatalog {

    // ISBN -> Book Title
    private Map<String, String> books = new HashMap<>();

    // 1. Add book
    public void addBook(String isbn, String title) {
        books.put(isbn, title);
        System.out.println("Added: " + isbn + " -> " + title);
    }

    // 2. Search by ISBN
    public void searchByISBN(String isbn) {
        if (books.containsKey(isbn)) {
            System.out.println("Book Found: " + books.get(isbn));
        } else {
            System.out.println("Book not found for ISBN: " + isbn);
        }
    }

    // 3. Remove book
    public void removeBook(String isbn) {
        if (books.remove(isbn) != null) {
            System.out.println("Removed book with ISBN: " + isbn);
        } else {
            System.out.println("Book not found to remove: " + isbn);
        }
    }

    // 4. Print all sorted by ISBN
    public void printSortedCatalog() {
        System.out.println("\n--- Library Catalog (Sorted by ISBN) ---");

        Map<String, String> sorted = new TreeMap<>(books);

        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // 5. Search by Title (Extended requirement)
    public void searchByTitle(String title) {
        boolean found = false;

        System.out.println("\nSearching for title: " + title);

        for (Map.Entry<String, String> entry : books.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(title)) {
                System.out.println("Found ISBN: " + entry.getKey());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found with title: " + title);
        }
    }

    // Main method (demo)
    public static void main(String[] args) {
        LibraryBookCatalog library = new LibraryBookCatalog();

        // 1. Add books
        library.addBook("978-1234567890", "Java Programming");
        library.addBook("978-1111111111", "Data Structures");
        library.addBook("978-2222222222", "Database Systems");
        library.addBook("978-3333333333", "Operating Systems");

        // 2. Search by ISBN
        library.searchByISBN("978-1111111111");
        library.searchByISBN("978-9999999999");

        // 3. Remove book
        library.removeBook("978-2222222222");

        // 4. Print sorted catalog
        library.printSortedCatalog();

        // 5. Search by title (extended)
        library.searchByTitle("Java Programming");
        library.searchByTitle("Machine Learning");
    }
}

