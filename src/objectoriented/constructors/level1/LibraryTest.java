package objectoriented.constructors.level1;

class Book1 {
    String title;
    String author;
    double price;
    boolean available;

    Book1(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book not available");
        }
    }

    void display() {
        System.out.println(title + " by " + author + " | Available: " + available);
    }
}

public class LibraryTest {
    public static void main(String[] args) {
        Book1 book1 = new Book1("Java Basics", "James Gosling", 450);

        book1.display();
        book1.borrowBook();
        book1.display();
    }
}

