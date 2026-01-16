package objectOriented.constructors.level1;

class Book2 {
    public String ISBN;          // public
    protected String title;      // protected
    private String author;       // private

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class EBook extends Book2 {
    void displayBook() {
        System.out.println("ISBN: " + ISBN);     // public
        System.out.println("Title: " + title);   // protected
        System.out.println("Author: " + getAuthor()); // private via method
    }
}

public class LibraryTest1 {
    public static void main(String[] args) {
        EBook ebook = new EBook();
        ebook.ISBN = "ISBN12345";
        ebook.title = "Java Programming";
        ebook.setAuthor("James Gosling");

        ebook.displayBook();
    }
}

