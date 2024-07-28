package main.java;

import main.java.books.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    private final List<Book> bookCatalog;

    public LibraryCatalog() {
        bookCatalog = new ArrayList<>();
        System.out.println("Library is open for storing main.java.books!");
    }

    public void addBook(Book book) {
        bookCatalog.add(book);
        System.out.println("Book " + book + " added successfully in library.");
    }

    public void deleteBook(Book book) {
        bookCatalog.remove(book);
        System.out.println("Book " + book + " deleted successfully from library.");
    }

    public void listBooks() {
        System.out.println("Library includes the following main.java.books:");
        for (Book book : bookCatalog) {
            System.out.println(book.getName());
        }
    }
}
