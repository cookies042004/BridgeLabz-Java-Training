package java8features;

import java.util.*;
import java.util.stream.*;

class Book {
    String title, author, genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String toString() { return title + " - " + rating; }
}

public class BookRecommendationApp {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
                new Book("Foundation", "Asimov", "Science Fiction", 4.2),
                new Book("Other", "Author", "Drama", 3.5)
        );

        List<BookRecommendation> page =
                books.stream()
                        .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
                        .map(b -> new BookRecommendation(b.title, b.rating))
                        .sorted(Comparator.comparing(br -> br.rating, Comparator.reverseOrder()))
                        .skip(0)
                        .limit(5)
                        .collect(Collectors.toList());

        System.out.println(page);
    }
}

