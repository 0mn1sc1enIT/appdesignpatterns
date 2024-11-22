import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class ReturnResult {
    private boolean isSuccess;
    private String message;

    public ReturnResult(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}

class Book {
    private String title;
    private String ISBN;
    private int publicationYear;
    private boolean availabilityStatus;
    private List<Author> authors = new ArrayList<>();

    public Book(String title, String ISBN, int publicationYear, boolean availabilityStatus) {
        this.title = title;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.availabilityStatus = availabilityStatus;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public ReturnResult changeAvailabilityStatus() {
        this.availabilityStatus = !this.availabilityStatus;
        return new ReturnResult(true, "Availability status changed successfully.");
    }

    public String getBookInfo() {
        return STR."Title: \{title}, ISBN: \{ISBN}, Year: \{publicationYear}";
    }

    public boolean isAvailable() {
        return availabilityStatus;
    }
}

class Author {
    private String name;
    private Date birthDate;

    public Author(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getAuthorInfo() {
        return STR."Author: \{name} \{birthDate}";
    }
}

abstract class User {
    protected int id;
    protected String name;
    protected String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public abstract ReturnResult register();
    public abstract ReturnResult login();
}

class Reader extends User {
    public Reader(int id, String name, String email) {
        super(id, name, email);
    }

    public Loan borrowBook(Book book) {
        if (book.isAvailable()) {
            return new Loan(book, this, new Date());
        } else {
            System.out.println("Book is not available for loan.");
            return null;
        }
    }

    public ReturnResult returnBook(Loan loan) {
        loan.returnBook();
        return new ReturnResult(true, "Book returned successfully.");
    }

    @Override
    public ReturnResult register() {
        return new ReturnResult(true, STR."Reader \{name} registered.");
    }

    @Override
    public ReturnResult login() {
        return new ReturnResult(true, STR."Reader \{name} logged in.");
    }
}

class Librarian extends User {
    public Librarian(int id, String name, String email) {
        super(id, name, email);
    }

    public ReturnResult addBook(Library library, Book book) {
        library.addBook(book);
        return new ReturnResult(true, STR."Book added: \{book.getBookInfo()}");
    }

    public ReturnResult editBook(Book book, String newTitle, String newIsbn, int newPublicationYear) {
        book.changeAvailabilityStatus();
        return new ReturnResult(true, STR."Book edited: \{book.getBookInfo()}");
    }

    public ReturnResult removeBook(Library library, Book book) {
        library.removeBook(book);
        return new ReturnResult(true, STR."Book removed: \{book.getBookInfo()}");
    }

    @Override
    public ReturnResult register() {
        return new ReturnResult(true, STR."Librarian \{name} registered.");
    }

    @Override
    public ReturnResult login() {
        return new ReturnResult(true, STR."Librarian \{name} logged in.");
    }
}

class Loan {
    private Book book;
    private Reader reader;
    private Date loanDate;
    private Date returnDate;

    public Loan(Book book, Reader reader, Date loanDate) {
        this.book = book;
        this.reader = reader;
        this.loanDate = loanDate;
        book.changeAvailabilityStatus();
    }

    public ReturnResult returnBook() {
        this.returnDate = new Date();
        book.changeAvailabilityStatus();
        return new ReturnResult(true, "Book returned successfully.");
    }
}

class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public ReturnResult addBook(Book book) {
        books.add(book);
        return new ReturnResult(true, "Book added successfully.");
    }

    public ReturnResult removeBook(Book book) {
        books.remove(book);
        return new ReturnResult(true, "Book removed successfully.");
    }

    public ReturnResult registerUser(User user) {
        users.add(user);
        return user.register();
    }

    public Loan loanBook(Book book, Reader reader) {
        Loan loan = reader.borrowBook(book);
        if (loan != null) {
            loans.add(loan);
        }
        return loan;
    }

}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian(1, "Alice", "alice@example.com");
        Reader reader = new Reader(2, "Bob", "bob@example.com");
        ReturnResult result;
        result = library.registerUser(librarian);
        System.out.println(result.getMessage());
        library.registerUser(reader);
        System.out.println(result.getMessage());
        Book book = new Book("Java Programming", "123456789", 2020, true);
        Author author = new Author("John Doe", new Date());
        book.addAuthor(author);

        result = librarian.addBook(library, book);
        System.out.println(result.getMessage());
        Loan loan = library.loanBook(book, reader);
        if (loan != null) {
            reader.returnBook(loan);
            System.out.println(result.getMessage());
        }
    }
}
