import model.*;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Java Programming", "Mark B.N", "1111", 3);
        Book book2 = new Book("Data Structures", "Eugene A.V", "2222", 2);
        Book book3 = new Book("Algorithms", "Lenon A.C", "3333", 1);

        System.out.println(library.addBook(book1));
        System.out.println(library.addBook(book2));
        System.out.println(library.addBook(book3));

        Reader reader1 = new Reader("Anton", 1);
        Reader reader2 = new Reader("Vlad", 2);

        System.out.println(library.registerReader(reader1));
        System.out.println(library.registerReader(reader2));

        System.out.println(library.giveBook("1111", 1)); // Успешная выдача книги
        System.out.println(library.giveBook("2222", 2)); // Успешная выдача книги

        System.out.println(library.giveBook("3333", 1));
        System.out.println(library.giveBook("3333", 2)); // Ошибка, книги больше нет

        System.out.println(library.returnBook("1111"));

        System.out.println(library.removeBook("2222"));
    }
}
