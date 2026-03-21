package com.gla.singleinheritance;
class Book {
    protected String title;
    protected int publicationYear;

    // Constructor
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display basic book info
    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Author subclass extending Book
class Author extends Book {
    private String authorName;
    private String bio;

    public Author(String title, int publicationYear, String authorName, String bio) {
        super(title, publicationYear);
        this.authorName = authorName;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // display book info
        System.out.println("Author Name: " + authorName);
        System.out.println("Biography: " + bio);
    }
}

// Demo class
public class LibraryDemo {
    public static void main(String[] args) {
        Author book1 = new Author(
                "The Alchemist",
                1988,
                "Paulo Coelho",
                "Brazilian author known for inspirational novels."
        );

        Author book2 = new Author(
                "1984",
                1949,
                "George Orwell",
                "English novelist, essayist, and journalist famous for dystopian works."
        );

        // Display details
        book1.displayInfo();
        System.out.println("-------------------------");
        book2.displayInfo();
    }
}

