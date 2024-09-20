package model;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;

    public Library() {
        books = new ArrayList<>();
        readers = new ArrayList<>();
    }

    public String addBook(Book book) {
        for (Book b : books) {
            if (b.getISBN().equals(book.getISBN())) {
                b.addCopies(book.getCopies());
                return "Added copies of " + book;
            }
        }
        books.add(book);
        return "Added: " + book;
    }


    public String removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getISBN().equals(isbn)) {
                books.remove(i);
                return "Book with ISBN " + isbn + " removed";
            }
        }
        return "Book with ISBN " + isbn + " not found";
    }


    public String registerReader(Reader reader) {
        readers.add(reader);
        return "Registered: " + reader;
    }

    public String giveBook(String ISBN, int readerId) {
        Book book = findBookByIsbn(ISBN);
        Reader reader = findReaderById(readerId);

        if (book != null && reader != null && book.removeCopy()) {
            return "Gave " + book.getTitle() + " to " + reader.getName();
        } else {
            return "Failed to give book";
        }
    }

    public String returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            book.returnCopy();
            return "Returned: " + book.getTitle();
        } else {
            return "Book not found";
        }
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    private Reader findReaderById(int id) {
        for (Reader reader : readers) {
            if (reader.getId() == id) {
                return reader;
            }
        }
        return null;
    }

    /*public void getBooks() {
        for (Book b: books) {
            System.out.println(b);
        }
    }*/
}

