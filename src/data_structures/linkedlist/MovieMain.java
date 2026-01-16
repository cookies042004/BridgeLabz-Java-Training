package data_structures.linkedlist;


// movie class
class Movie{
    String movieTitle;
    String director;
    int yearOfRelease;
    double rating;

    Movie(String movieTitle, String director, int yearOfRelease, double rating){
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
    }
}

// node class
class NodeMovie{
    Movie data;
    NodeMovie next;
    NodeMovie prev;

    NodeMovie(Movie data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// movieLinkedList class containing different methods
class MovieLinkedList{
    NodeMovie head;
    NodeMovie tail;

    // adding node at beginning
    public void addAtBeginning(Movie m){
        NodeMovie newNode = new NodeMovie(m);

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // adding node at end
    public void addAtEnd(Movie m){
        NodeMovie newNode = new NodeMovie(m);

        if(tail == null){
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    // adding at specific position
    public void addAtSpecificPosition(Movie m, int pos){
        NodeMovie newNode = new NodeMovie(m);

        if(pos <= 1){
            addAtBeginning(m);
            return;
        }

        // creating node pointer help in iterating
        NodeMovie temp = head;

        for(int i = 1;i < pos - 1 && temp != null;i++){
            temp = temp.next;
        }

        if(temp == null){
            addAtEnd(m);
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if(temp.next != null){
            temp.next.prev = newNode;
        }

        temp.next = newNode;

        if(newNode.next == null){
            tail = newNode;
        }
    }

    // remove node by movie title
    public void removeByTitle(String title){
        NodeMovie temp = head;

        while(temp != null && !temp.data.movieTitle.equalsIgnoreCase(title)){
            temp = temp.next;
        }

        if(temp == null){
            System.out.println("Movie not found");
            return;
        }

        if(temp == head){
            head = head.next;
        }

        if(temp == tail){
            tail = tail.prev;
        }

        if(temp.next != null){
            temp.next.prev = temp.prev;
        }

        if(temp.prev != null){
            temp.prev.next = temp.next;
        }

        temp.next = null;
        temp.prev = null;

        System.out.println("Movie removed: " + title);
    }

    // Search by Director
    public void searchByDirector(String director) {
        NodeMovie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.director.equalsIgnoreCase(director)) {
                printMovie(temp.data);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found for director: " + director);
    }

    // Search by Rating
    public void searchByRating(double rating) {
        NodeMovie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.rating == rating) {
                printMovie(temp.data);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found with rating: " + rating);
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        NodeMovie temp = head;

        while (temp != null) {
            if (temp.data.movieTitle.equalsIgnoreCase(title)) {
                temp.data.rating = newRating;
                System.out.println("Rating updated for: " + title);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found!");
    }

    // Display forward
    public void displayForward() {
        NodeMovie temp = head;
        if (temp == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("\nMovies (Forward):");
        while (temp != null) {
            printMovie(temp.data);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        NodeMovie temp = tail;
        if (temp == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("\nMovies (Reverse):");
        while (temp != null) {
            printMovie(temp.data);
            temp = temp.prev;
        }
    }

    // Helper method
    private void printMovie(Movie m) {
        System.out.println("Title: " + m.movieTitle +
                ", Director: " + m.director +
                ", Year: " + m.yearOfRelease +
                ", Rating: " + m.rating);
    }
}


public class MovieMain {
    public static void main(String[] args) {
        MovieLinkedList list = new MovieLinkedList();

        list.addAtBeginning(new Movie("Inception", "Nolan", 2010, 9.0));
        list.addAtEnd(new Movie("Interstellar", "Nolan", 2014, 8.6));
        list.addAtSpecificPosition(new Movie("Avatar", "Cameron", 2009, 7.8), 2);

        list.displayForward();
        list.displayReverse();

        list.searchByDirector("Nolan");
        list.searchByRating(8.6);

        list.updateRating("Avatar", 9.1);

        list.removeByTitle("Inception");

        list.displayForward();
    }
}
