package model;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int copies;

    public Book(String title, String author, String ISBN, int copies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getCopies() {
        return copies;
    }

    public void addCopies(int copies) {
        this.copies += copies;
    }

    public boolean removeCopy() {
        if (this.copies > 0) {
            this.copies--;
            return true;
        }
        return false;
    }

    public void returnCopy() {
        this.copies++;
    }

    @Override
    public String toString() {
        return "Book" + "\ntitle=" + title + "\nauthor=" + author + "\nISBN=" + ISBN + "\ncopies=" + copies;
    }
}
