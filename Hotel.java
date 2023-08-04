package hotelmanagementsystem;

import java.util.*;

public class Hotel {

	    private List<Room> rooms;
	    private List<Reservation> reservations;
	    private List<Bill> bills;
	    private int nextReservationId;
	    private int nextBillId;

	    public Hotel() {
	        this.rooms = new ArrayList<>();
	        this.reservations = new ArrayList<>();
	        this.bills = new ArrayList<>();
	        this.nextReservationId = 1;
	        this.nextBillId = 1;
	    }

	    public void addRoom(Room room) {
	        rooms.add(room);
	    }

	    public void makeReservation(Guest guest, RoomType roomType, Date checkInDate, Date checkOutDate) {
	        Room availableRoom = findAvailableRoom(roomType);
	        if (availableRoom != null) {
	            Reservation reservation = new Reservation(nextReservationId, guest, availableRoom, checkOutDate, checkOutDate);
	            reservations.add(reservation);
	            availableRoom.setAvailable(false);
	            nextReservationId++;
	            System.out.println("Reservation successful. Reservation ID: " + reservation.getReservationId());
	        } else {
	            System.out.println("No available room of type " + roomType);
	        }
	    }

	    private Room findAvailableRoom(RoomType roomType) {
	        for (Room room : rooms) {
	            if (room.getType() == roomType && room.isAvailable()) {
	                return room;
	            }
	        }
	        return null;
	    }

	    public void cancelReservation(int reservationId) {
	        Reservation reservation = findReservationById(reservationId);
	        if (reservation != null) {
	            if (reservation.isCheckedIn()) {
	                System.out.println("Cannot cancel a checked-in reservation.");
	                return;
	            }
	            reservation.getRoom().setAvailable(true);
	            reservations.remove(reservation);
	            System.out.println("Reservation canceled.");
	        } else {
	            System.out.println("Invalid reservation ID.");
	        }
	    }

	    private Reservation findReservationById(int reservationId) {
	        for (Reservation reservation : reservations) {
	            if (reservation.getReservationId() == reservationId) {
	                return reservation;
	            }
	        }
	        return null;
	    }

	    public void checkIn(int reservationId) {
	        Reservation reservation = findReservationById(reservationId);
	        if (reservation != null) {
	            if (reservation.isCheckedIn()) {
	                System.out.println("Reservation is already checked-in.");
	                return;
	            }
	            if (reservation.isCheckedOut()) {
	                System.out.println("Cannot check-in a checked-out reservation.");
	                return;
	            }
	            reservation.setCheckedIn(true);
	            System.out.println("Checked-in successfully.");
	        } else {
	            System.out.println("Invalid reservation ID.");
	        }
	    }

	    public void checkOut(int reservationId) {
	        Reservation reservation = findReservationById(reservationId);
	        if (reservation != null) {
	            if (!reservation.isCheckedIn()) {
	                System.out.println("Cannot check-out a reservation that is not checked-in.");
	                return;
	            }
	            if (reservation.isCheckedOut()) {
	                System.out.println("Reservation is already checked-out.");
	                return;
	            }
	            reservation.setCheckedOut(true);
	            double amount = calculateBillAmount(reservation);
	            Bill bill = new Bill(nextBillId, reservation, amount);
	            bills.add(bill);
	            nextBillId++;
	            System.out.println("Checked-out successfully. Bill ID: " + bill.getBillId() + ", Amount: $" + bill.getAmount());
	        } else {
	            System.out.println("Invalid reservation ID.");
	        }
	    }

	    private double calculateBillAmount(Reservation reservation) {
	        // Perform calculation based on reservation details (e.g., room rate, duration)
	        // For simplicity, let's assume a fixed rate per day
	        int durationInDays = (int) ((reservation.getCheckOutDate().getTime() - reservation.getCheckInDate().getTime()) / (24 * 60 * 60 * 1000));
	        double roomRate = getRoomRate(reservation.getRoom().getType());
	        return roomRate * durationInDays;
	    }

	    private double getRoomRate(RoomType roomType) {
	        // Return the room rate based on the room type
	        // For simplicity, let's use fixed rates
	        switch (roomType) {
	            case SINGLE:
	                return 100.0;
	            case DOUBLE:
	                return 150.0;
	            case SUITE:
	                return 250.0;
	            default:
	                return 0.0;
	        }
	    }

	    public void displayAvailableRooms() {
	        System.out.println("Available Rooms:");
	        for (Room room : rooms) {
	            if (room.isAvailable()) {
	                System.out.println("Room number: " + room.getRoomNumber() + " - Type: " + room.getType());
	            }
	        }
	    }

	    public void displayReservations() {
	        System.out.println("Reservations:");
	        for (Reservation reservation : reservations) {
	            System.out.println("Reservation ID: " + reservation.getReservationId() +
	                    " - Guest: " + reservation.getGuest().getName() +
	                    " - Room: " + reservation.getRoom().getRoomNumber() +
	                    " - Type: " + reservation.getRoom().getType() +
	                    " - Check-in: " + reservation.getCheckInDate() +
	                    " - Check-out: " + reservation.getCheckOutDate());
	        }
	    }

	    public void displayBills() {
	        System.out.println("Bills:");
	        for (Bill bill : bills) {
	            System.out.println("Bill ID: " + bill.getBillId() +
	                    " - Reservation ID: " + bill.getReservation().getReservationId() +
	                    " - Amount: $" + bill.getAmount() +
	                    " - Paid: " + (bill.isPaid() ? "Yes" : "No"));
	        }
	    }

	    public void markBillAsPaid(int billId) {
	        Bill bill = findBillById(billId);
	        if (bill != null) {
	            bill.setPaid(true);
	            System.out.println("Bill marked as paid.");
	        } else {
	            System.out.println("Invalid bill ID.");
	        }
	    }

	    private Bill findBillById(int billId) {
	        for (Bill bill : bills) {
	            if (bill.getBillId() == billId) {
	                return bill;
	            }
	        }
	        return null;
	    }
}
