import java.util.Date;

public class Main {
    class Book {
        private String title;
        private String author;
        private String isbn;
        private boolean isAvailable;

        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.isAvailable = true;
        }

        public void markAsLoaned() {
            isAvailable = false;
        }

        public void markAsAvailable() {
            isAvailable = true;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getIsbn() {
            return isbn;
        }
    }

    class Reader {
        private int id;
        private String name;
        private String email;

        public Reader(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public void borrowBook(Book book) {
            if (book.isAvailable()) {
                book.markAsLoaned();
                System.out.println(STR."\{name} borrowed the book: \{book.getTitle()}");
            } else {
                System.out.println("Book is not available.");
            }
        }

        public void returnBook(Book book) {
            book.markAsAvailable();
            System.out.println(STR."\{name} returned the book: \{book.getTitle()}");
        }
    }

    class Librarian {
        private int id;
        private String name;
        private String position;

        public Librarian(int id, String name, String position) {
            this.id = id;
            this.name = name;
            this.position = position;
        }

        public void addBook(Book book) {
            System.out.println(STR."Librarian added a new book: \{book.getTitle()}");
        }

        public void removeBook(Book book) {
            System.out.println(STR."Librarian removed the book: \{book.getTitle()}");
        }
    }

    class Loan {
        private Book book;
        private Reader reader;
        private Date loanDate;
        private Date returnDate;

        public Loan(Book book, Reader reader) {
            this.book = book;
            this.reader = reader;
            this.loanDate = new Date();
        }

        public void issueLoan() {
            System.out.println(STR."Loan issued for book: \{book.getTitle()} to \{reader.name}");
        }

        public void completeLoan() {
            this.returnDate = new Date();
            System.out.println(STR."Loan completed for book: \{book.getTitle()} by \{reader.name}");
        }
    }
    public void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe", "123456");
        Reader reader1 = new Reader(1, "Alice", "alice@example.com");
        Librarian librarian = new Librarian(1, "Bob", "Head Librarian");

        librarian.addBook(book1);

        reader1.borrowBook(book1);
        Loan loan = new Loan(book1, reader1);
        loan.issueLoan();

        reader1.returnBook(book1);
        loan.completeLoan();
    }
}
