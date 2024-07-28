package main.java;

import main.java.books.ArtAlbum;
import main.java.books.Novel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();

        Novel novel1 = new Novel("Novel1", 100, "mister");
        Novel novel2 = new Novel("Novel2", 150, "drama");

        ArtAlbum artAlbum1 = new ArtAlbum("Art album1", 125, "Premium");
        ArtAlbum artAlbum2 = new ArtAlbum("Art album2", 185, "Universal");

        System.out.println();
        library.addBook(novel1);
        library.addBook(novel2);
        library.addBook(artAlbum1);
        library.addBook(artAlbum2);

        System.out.println();
        library.listBooks();

        System.out.println();
        library.deleteBook(novel1);

        System.out.println();
        library.listBooks();
    }
}