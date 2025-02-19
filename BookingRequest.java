// Seat.java
public class Seat {
    private int seatNumber;
    private boolean isBooked;
    private String bookedBy;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
        this.bookedBy = null;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void book(String customerName) {
        this.isBooked = true;
        this.bookedBy = customerName;
    }

    @Override
    public String toString() {
        return "Seat " + seatNumber + (isBooked ? " (Booked by " + bookedBy + ")" : " (Available)");
    }
}

// BookingSystem.java
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Seat> seats;
    private final Object lock = new Object();

    public BookingSystem(int totalSeats) {
        seats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public boolean bookSeat(int seatNumber, String customerName) {
        synchronized (lock) {
            if (seatNumber < 1 || seatNumber > seats.size()) {
                System.out.println("Invalid seat number: " + seatNumber);
                return false;
            }

            Seat seat = seats.get(seatNumber - 1);
            if (seat.isBooked()) {
                System.out.println("Seat " + seatNumber + " is already booked!");
                return false;
            }

            seat.book(customerName);
            System.out.println("Seat " + seatNumber + " successfully booked for " + customerName);
            return true;
        }
    }

    public void displaySeats() {
        synchronized (lock) {
            System.out.println("\nCurrent Seat Status:");
            for (Seat seat : seats) {
                System.out.println(seat);
            }
            System.out.println();
        }
    }
}

// BookingRequest.java
public class BookingRequest implements Runnable {
    private BookingSystem bookingSystem;
    private String customerName;
    private int seatNumber;
    private boolean isVIP;

    public BookingRequest(BookingSystem bookingSystem, String customerName, int seatNumber, boolean isVIP) {
        this.bookingSystem = bookingSystem;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
        this.isVIP = isVIP;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(isVIP ? Thread.MAX_PRIORITY : Thread.NORM_PRIORITY);
        System.out.println("Processing booking request for " + customerName + 
                          (isVIP ? " (VIP)" : "") + " - Seat " + seatNumber);
        bookingSystem.bookSeat(seatNumber, customerName);
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        // Create a booking system with 10 seats
        BookingSystem bookingSystem = new BookingSystem(10);
        
        // Display initial seat status
        bookingSystem.displaySeats();

        // Create multiple booking requests
        Thread[] threads = new Thread[] {
            new Thread(new BookingRequest(bookingSystem, "John", 1, false)),
            new Thread(new BookingRequest(bookingSystem, "Alice", 1, true)),  // VIP trying to book same seat
            new Thread(new BookingRequest(bookingSystem, "Bob", 2, false)),
            new Thread(new BookingRequest(bookingSystem, "Carol", 3, true)),  // VIP
            new Thread(new BookingRequest(bookingSystem, "David", 2, true)),  // VIP trying to book same seat
            new Thread(new BookingRequest(bookingSystem, "Eve", 4, false))
        };

        // Start all booking threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all bookings to complete
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display final seat status
        System.out.println("\nFinal seat status after all bookings:");
        bookingSystem.displaySeats();
    }
}
