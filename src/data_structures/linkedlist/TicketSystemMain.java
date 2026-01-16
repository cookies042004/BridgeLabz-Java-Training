package data_structures.linkedlist;

// Ticket class
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

// Node for Circular Linked List
class TicketNode {
    Ticket data;
    TicketNode next;

    TicketNode(Ticket data) {
        this.data = data;
    }
}

// Circular Linked List for Ticket Reservation System
class TicketCircularList {

    TicketNode head = null;

    // ✔ Add ticket at end
    public void addTicket(Ticket t) {
        TicketNode newNode = new TicketNode(t);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        TicketNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // ✔ Remove ticket by ID
    public void removeTicket(int ticketId) {
        if (head == null)
            return;

        TicketNode temp = head, prev = null;

        // If head needs to be removed
        if (head.data.ticketId == ticketId) {

            // Only one ticket
            if (head.next == head) {
                head = null;
                return;
            }

            // Find last node to fix circular link
            TicketNode last = head;
            while (last.next != head)
                last = last.next;

            head = head.next;
            last.next = head;
            return;
        }

        // For non-head nodes
        do {
            prev = temp;
            temp = temp.next;

            if (temp.data.ticketId == ticketId) {
                prev.next = temp.next;
                return;
            }

        } while (temp != head);
    }

    // ✔ Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("\nCurrent Tickets:");

        TicketNode temp = head;
        do {
            printTicket(temp.data);
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // ✔ Search by Customer Name OR Movie Name
    public void searchTicket(String key) {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }

        boolean found = false;
        TicketNode temp = head;

        do {
            if (temp.data.customerName.equalsIgnoreCase(key) ||
                    temp.data.movieName.equalsIgnoreCase(key)) {

                printTicket(temp.data);
                found = true;
            }

            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No matching ticket found.");
    }

    // ✔ Count total tickets
    public int countTickets() {
        if (head == null)
            return 0;

        int count = 0;
        TicketNode temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    // Print ticket details
    private void printTicket(Ticket t) {
        System.out.println("TicketID: " + t.ticketId +
                ", Customer: " + t.customerName +
                ", Movie: " + t.movieName +
                ", Seat: " + t.seatNumber +
                ", Time: " + t.bookingTime);
    }
}

public class TicketSystemMain {
    public static void main(String[] args) {

        TicketCircularList system = new TicketCircularList();

        system.addTicket(new Ticket(501, "Akhil", "Joker 2", "A12", "10:30 AM"));
        system.addTicket(new Ticket(502, "Rahul", "Avatar 3", "C10", "9:00 PM"));
        system.addTicket(new Ticket(503, "Nikita", "Joker 2", "B02", "10:30 AM"));

        system.displayTickets();

        System.out.println("Searching for 'Joker 2':");
        system.searchTicket("Joker 2");

        system.removeTicket(502);
        System.out.println("\nAfter removing ticket 502:");
        system.displayTickets();

        System.out.println("Total tickets booked: " + system.countTickets());
    }
}

