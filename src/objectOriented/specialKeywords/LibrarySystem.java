package objectOriented.specialKeywords;

class Library{
    static String libraryName = "Central Library";

    final String isbn;
    String title, author;

    Library(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    void displayDetails() {
        if (this instanceof Library) {
            System.out.println("Title: " + this.title);
            System.out.println("Author: " + this.author);
            System.out.println("ISBN: " + this.isbn);
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library b = new Library("Java Basics", "James", "ISBN1234");
        Library.displayLibraryName();
        b.displayDetails();
    }
}
