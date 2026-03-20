package com.gla.library.books;

public class Book {

        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public void displayBook() {
            System.out.println("Book ID: " + bookId +
                    ", Title: " + title +
                    ", Author: " + author);
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }
    }

