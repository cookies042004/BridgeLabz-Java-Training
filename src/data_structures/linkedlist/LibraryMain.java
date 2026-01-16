package data_structures.linkedlist;

// Book class
class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;

    Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

// Node class (Doubly Linked List)
class NodeBook {
    Book data;
    NodeBook next;
    NodeBook prev;

    NodeBook(Book data) {
        this.data = data;
    }
}

// Doubly Linked List for Library System
class LibraryDLL {

    NodeBook head = null;
    NodeBook tail = null;

    // ✔ Add at beginning
    public void addAtBeginning(Book b) {
        NodeBook newNode = new NodeBook(b);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // ✔ Add at end
    public void addAtEnd(Book b) {
        NodeBook newNode = new NodeBook(b);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // ✔ Add at specific position (1-based index)
    public void addAtPosition(Book b, int pos) {
        if (pos <= 1) {
            addAtBeginning(b);
            return;
        }

        NodeBook newNode = new NodeBook(b);
        NodeBook temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(b);
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // ✔ Remove book by ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }

        NodeBook temp = head;

        // If head is to be removed
        if (temp.data.bookId == id) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null; // empty list
            System.out.println("Book removed!");
            return;
        }

        // Traverse
        while (temp != null && temp.data.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book ID not found.");
            return;
        }

        if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Book removed!");
    }

    // ✔ Search by Title
    public void searchByTitle(String title) {
        NodeBook temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.title.equalsIgnoreCase(title)) {
                printBook(temp.data);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No book found with title: " + title);
    }

    // ✔ Search by Author
    public void searchByAuthor(String author) {
        NodeBook temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.author.equalsIgnoreCase(author)) {
                printBook(temp.data);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No book found for author: " + author);
    }

    // ✔ Update Availability Status
    public void updateAvailability(int id, boolean status) {
        NodeBook temp = head;

        while (temp != null) {
            if (temp.data.bookId == id) {
                temp.data.isAvailable = status;
                System.out.println("Availability updated!");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found!");
    }

    // ✔ Display forward
    public void displayForward() {
        System.out.println("\nLibrary (Forward):");
        NodeBook temp = head;

        while (temp != null) {
            printBook(temp.data);
            temp = temp.next;
        }
    }

    // ✔ Display reverse
    public void displayReverse() {
        System.out.println("\nLibrary (Reverse):");
        NodeBook temp = tail;

        while (temp != null) {
            printBook(temp.data);
            temp = temp.prev;
        }
    }

    // ✔ Count books
    public int countBooks() {
        int count = 0;
        NodeBook temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // Helper print
    public void printBook(Book b) {
        System.out.println("ID: " + b.bookId +
                ", Title: " + b.title +
                ", Author: " + b.author +
                ", Genre: " + b.genre +
                ", Available: " + (b.isAvailable ? "Yes" : "No"));
    }
}

public class LibraryMain {
    public static void main(String[] args) {

        LibraryDLL lib = new LibraryDLL();

        lib.addAtBeginning(new Book("The Alchemist", "Paulo Coelho", "Fiction", 101, true));
        lib.addAtEnd(new Book("Atomic Habits", "James Clear", "Self-help", 102, true));
        lib.addAtPosition(new Book("1984", "George Orwell", "Dystopian", 103, false), 2);

        lib.displayForward();
        lib.displayReverse();

        lib.searchByTitle("1984");
        lib.searchByAuthor("James Clear");

        lib.updateAvailability(101, false);

        lib.removeById(102);

        lib.displayForward();

        System.out.println("\nTotal books: " + lib.countBooks());
    }
}

