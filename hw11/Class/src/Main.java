public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Бахытгуль");
        Reader reader = new Reader("Аружан");

        Book book1 = new Book("Война и мир", "Лев Толстой", "123456789");
        Book book2 = new Book("1984", "Джордж Орвел", "987654321");

        librarian.AddBook(library, book1);
        librarian.AddBook(library, book2);

        librarian.ListAllBooks(library);

        reader.RentBook(book1);
        System.out.println("\nПосле того, как Аружан арендовала книгу 'Война и мир':");
        librarian.ListAllBooks(library);

        reader.ReturnBook(book1);
        System.out.println("\nПосле того, как Аружан вернула книгу 'Война и мир':");
        librarian.ListAllBooks(library);
    }
}
