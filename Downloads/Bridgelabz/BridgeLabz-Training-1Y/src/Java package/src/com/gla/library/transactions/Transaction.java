package com.gla.library.transactions;

import com.gla.library.books.Book;
import com.gla.library.members.Member;

    public class Transaction {

        public void issueBook(Book book, Member member) {
            System.out.println("\nBook Issued Successfully!");
            System.out.println("Book: " + book.getTitle());
            System.out.println("Issued To: " + member.getName());
        }
    }

