package objectoriented.polymorphism;

import java.util.*;

// interface
interface Reservable {
    void reserveItem(String user);
    boolean checkAvailability();
}

// LibraryItem
abstract class LibraryItem implements Reservable {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Encapsulation
    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }

    public abstract int getLoanDuration(); // ABSTRACT
}

// Book class
class Book extends LibraryItem {
    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() { return 14; }

    @Override
    public void reserveItem(String user) {
        System.out.println("Book reserved by " + user);
    }

    @Override
    public boolean checkAvailability() { return true; }
}

// Magazine class
class Magazine extends LibraryItem {
    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() { return 7; }

    @Override
    public void reserveItem(String user) {
        System.out.println("Magazine reserved by " + user);
    }

    @Override
    public boolean checkAvailability() { return false; }
}

// DVD class
class DVD extends LibraryItem {
    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() { return 3; }

    @Override
    public void reserveItem(String user) {
        System.out.println("DVD reserved by " + user);
    }

    @Override
    public boolean checkAvailability() { return true; }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book(101, "Java Basics", "James"));
        items.add(new Magazine(102, "Tech Monthly", "Editor X"));
        items.add(new DVD(103, "Inception", "Nolan"));

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            System.out.println("Available: " + item.checkAvailability());
            System.out.println("--------------------------------------");
        }
    }
}

