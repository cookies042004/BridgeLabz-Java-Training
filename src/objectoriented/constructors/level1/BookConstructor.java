package objectoriented.constructors.level1;

class Book{
    String title,author;
    double price;

    Book(){
        System.out.println("Default Constructor is called");
    }

    Book(String author,String title,double price){
        System.out.println("Constructor with parameters is called");
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
    }
}

public class BookConstructor {
    public static void main(String[] args) {
        // creating object of class Book, and it will call default constructor
        Book2 b = new Book2();

        // creating object of class Book, and it will call parameterized constructor
//        Book2 b1 = new Book2("Ankur Warikoo","Do Epic Shit",209);
    }
}
