package objectOriented.oops.level1;

class Book{
    String title,author;
    double price;

    // method for displaying details
    void displayDetails(){
        System.out.println("Book : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
    }
}

public class HandleBook {
    public static void main(String[] args) {
        // creating object of class book
        Book b = new Book();

        // assigning values
        b.title = "Do Epic Shit";
        b.author = "Ankur Warikoo";
        b.price = 215;

        // calling method display
        b.displayDetails();
    }
}
