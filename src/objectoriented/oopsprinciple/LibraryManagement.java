package objectoriented.oopsprinciple;

import java.util.ArrayList;

class Book{
    String title;
    String author;

    Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    void displayDetails(){
        System.out.println("Title : " + title + " , Author : " + author);
    }
}

class Library{
    String libraryName;
    ArrayList<Book> books = new ArrayList<>();

    Library(String libraryName){
        this.libraryName = libraryName;
    }

    void addBook(Book b){
        books.add(b);
    }

    void displayLibrary(){
        System.out.println("Library Name : " +  libraryName);
        System.out.println("Books in Library : ");
        for(Book b : books){
            b.displayDetails();
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        // creating books independently
        Book b1 = new Book("The epic shit","Ankur Warikoo");
        Book b2 = new Book("Python Crash Course", "Eric Matthes");
        Book b3 = new Book("C++ Primer", "Stanley Lippman");

        // creating library
        Library l1 = new Library("School Library");
        Library l2 = new Library("University Library");

        l1.addBook(b1);
        l1.addBook(b2);
        l1.addBook(b3);

        l2.addBook(b2);
        l2.addBook(b2);
        l2.addBook(b1);

        l1.displayLibrary();

        l2.displayLibrary();
    }
}
