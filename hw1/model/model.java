package model;
import java.util.ArrayList;

public class model {
    class Book {
        String name;
        String author;
        String ISBN;
        int amount;

    }
    class Reader {
        String name;
        int ID;
    }
    class Library {
        ArrayList<Book> books;
        ArrayList<Reader> readers;

        public void AddBook(Book book) {
            books.add(book);
        }

        public void DeleteBook(Book book) {
            books.remove(book);
        }

    }
}
