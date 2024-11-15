import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String name;
    private List<Book> rentedBooks;

    public Reader(String name) {
        this.name = name;
        this.rentedBooks = new ArrayList<>();
    }

    public boolean RentBook(Book book) {
        if (book.rent()) {
            rentedBooks.add(book);
            return true;
        }
        return false;
    }

    public void ReturnBook(Book book) {
        if (rentedBooks.contains(book)) {
            book.returnBook();
            rentedBooks.remove(book);
        }
    }

    public void ListRentedBooks() {
        System.out.println(STR."\{name} арендовал следующие книги:");
        for (Book book : rentedBooks) {
            System.out.println(book.getTitle());
        }
    }
}
