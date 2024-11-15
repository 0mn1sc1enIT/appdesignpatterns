public class Librarian {
    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public void AddBook(Library library, Book book) {
        library.AddBook(book);
    }

    public void RemoveBook(Library library, Book book) {
        library.RemoveBook(book);
    }

    public void ListAllBooks(Library library) {
        library.GetAvailableBooks();
    }
}
