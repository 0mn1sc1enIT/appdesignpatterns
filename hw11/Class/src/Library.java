import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void AddBook(Book book) {
        books.add(book);
    }

    public void RemoveBook(Book book) {
        books.remove(book);
    }

    public void GetAvailableBooks() {
        System.out.println("В наличии следующие книги:");
        for (Book book : books) {
            if (book.getStatus()) {
                System.out.println(book.getTitle());
            }
        }
    }
}
