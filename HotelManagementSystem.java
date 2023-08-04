package hotelmanagementsystem;

import java.util.Date;

public class HotelManagementSystem {
	
    public static void main(String[] args) {
        // Create a hotel
        Hotel hotel = new Hotel();

        // Create some rooms
        Room room1 = new Room(101, RoomType.SINGLE);
        Room room2 = new Room(102, RoomType.DOUBLE);
        Room room3 = new Room(103, RoomType.SUITE);

        // Add rooms to the hotel
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);

        // Display available rooms
        hotel.displayAvailableRooms();

        // Make a reservation
        Guest guest1 = new Guest("John Doe", "john.doe@example.com");
        hotel.makeReservation(guest1, RoomType.SINGLE, new Date(), new Date());

        // Display reservations
        hotel.displayReservations();

        // Check-in
        hotel.checkIn(1);

        // Display reservations after check-in
        hotel.displayReservations();

        // Check-out
        hotel.checkOut(1);

        // Display bills
        hotel.displayBills();

        // Mark bill as paid
        hotel.markBillAsPaid(1);

        // Display bills after payment
        hotel.displayBills();
    }
}