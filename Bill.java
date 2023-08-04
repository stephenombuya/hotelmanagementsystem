package hotelmanagementsystem;

public class Bill {
	
	    private int billId;
	    private Reservation reservation;
	    private double amount;
	    private boolean isPaid;

	    public Bill(int billId, Reservation reservation, double amount) {
	        this.billId = billId;
	        this.reservation = reservation;
	        this.amount = amount;
	        this.isPaid = false;
	    }

	    // Getters and setters

	    public int getBillId() {
	        return billId;
	    }

	    public void setBillId(int billId) {
	        this.billId = billId;
	    }

	    public Reservation getReservation() {
	        return reservation;
	    }

	    public void setReservation(Reservation reservation) {
	        this.reservation = reservation;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }

	    public boolean isPaid() {
	        return isPaid;
	    }

	    public void setPaid(boolean paid) {
	        isPaid = paid;
	    }
}
