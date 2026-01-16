package objectOriented.oops.level2;

class MovieTicket{
    String movieName;
    int seatNumber;
    double price;

    // method for booking seat
    void book(int seatNumber,double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket Booked Successfully");
    }

    // method for displaying details
    void displayDetails(){
        System.out.println("Movie : " + movieName);
        System.out.println("SeatNumber : " + seatNumber);
        System.out.println("Price : " + price);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        // creating object of class MovieTicket
        MovieTicket m = new MovieTicket();

        // assigning values
        m.movieName = "Dhurandhar";

        // calling method for booking seat
        m.book(25,250);

        // calling method for displaying details
        m.displayDetails();
    }
}
