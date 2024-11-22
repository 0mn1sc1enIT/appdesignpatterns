import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Book {
    private String title;
    private String author;
    private String genre;
    private String isbn;

    public Book(String title, String author, String genre, String isbn) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return STR."Book{title='\{title}\{'\''}, author='\{author}\{'\''}, genre='\{genre}\{'\''}, isbn='\{isbn}\{'\''}\{'}'}";
    }
}

class Reader {
    private String firstName;
    private String lastName;
    private String ticketNumber;

    public Reader(String firstName, String lastName, String ticketNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ticketNumber = ticketNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getTicketNumber() {
        return ticketNumber;
    }
}

class Catalog {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Optional<Book> searchByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst();
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchByGenre(String genre) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                results.add(book);
            }
        }
        return results;
    }
}

class AccountingSystem {
    private List<String> loanRecords = new ArrayList<>();

    public void recordLoan(Reader reader, Book book) {
        loanRecords.add(STR."Issued: \{book} to \{reader.getFirstName()} \{reader.getLastName()}");
    }

    public void recordReturn(Reader reader, Book book) {
        loanRecords.add(STR."Returned: \{book} by \{reader.getFirstName()} \{reader.getLastName()}");
    }

    public List<String> getLoanRecords() {
        return loanRecords;
    }
}

class Librarian {
    private Catalog catalog;
    private AccountingSystem accountingSystem;

    public Librarian(Catalog catalog, AccountingSystem accountingSystem) {
        this.catalog = catalog;
        this.accountingSystem = accountingSystem;
    }

    public void issueBook(Reader reader, String title) {
        Optional<Book> bookOpt = catalog.searchByTitle(title);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            accountingSystem.recordLoan(reader, book);
            System.out.println(STR."Book issued: \{book}");
        } else {
            System.out.println("Book not found in catalog.");
        }
    }

    public void returnBook(Reader reader, String title) {
        Optional<Book> bookOpt = catalog.searchByTitle(title);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            accountingSystem.recordReturn(reader, book);
            System.out.println(STR."Book returned: \{book}");
        } else {
            System.out.println("Book not found in catalog.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        AccountingSystem accountingSystem = new AccountingSystem();
        Librarian librarian = new Librarian(catalog, accountingSystem);
        Reader reader = new Reader("John", "Doe", "T123");

        Book book1 = new Book("Java Programming", "Author A", "Programming", "12345");
        Book book2 = new Book("Python Basics", "Author B", "Programming", "67890");

        catalog.addBook(book1);
        catalog.addBook(book2);

        librarian.issueBook(reader, "Java Programming");

        librarian.returnBook(reader, "Java Programming");

        System.out.println("Loan Records:");
        accountingSystem.getLoanRecords().forEach(System.out::println);
    }
}
