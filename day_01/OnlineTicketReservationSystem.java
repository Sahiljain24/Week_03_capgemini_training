import java.time.LocalDateTime;
import java.util.*;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, LocalDateTime bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class OnlineTicketReservationSystem {
    private Ticket head;
    private Ticket tail;
    private int totalTickets;

    public OnlineTicketReservationSystem() {
        this.head = null;
        this.tail = null;
        this.totalTickets = 0;
    }

    // Add a new ticket reservation at the end
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, LocalDateTime.now());
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        totalTickets++;
        System.out.println("Ticket booked successfully for " + customerName + "!");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = tail;
        do {
            if (current.ticketID == ticketID) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                totalTickets--;
                System.out.println("Ticket with ID " + ticketID + " removed successfully.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket with ID " + ticketID + " not found.");
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        Ticket current = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("[Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName + ", Movie Name: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime + "]");
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("[Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName + ", Movie Name: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime + "]");
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for the given keyword.");
        }
    }

    // Calculate the total number of booked tickets
    public int getTotalTickets() {
        return totalTickets;
    }

    public static void main(String[] args) {
        OnlineTicketReservationSystem system = new OnlineTicketReservationSystem();

        // Adding tickets
        system.addTicket(1, "Alice", "Avatar", "A1");
        system.addTicket(2, "Bob", "Titanic", "B2");
        system.addTicket(3, "Charlie", "Avatar", "A2");

        // Displaying tickets
        system.displayTickets();

        // Searching for a ticket
        System.out.println("\nSearching for tickets for 'Avatar':");
        system.searchTicket("Avatar");

        // Removing a ticket
        System.out.println("\nRemoving ticket with ID 2:");
        system.removeTicket(2);

        // Displaying tickets after removal
        system.displayTickets();

        // Total tickets count
        System.out.println("\nTotal number of tickets: " + system.getTotalTickets());
    }
}
