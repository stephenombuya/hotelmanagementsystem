@Entity
class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    @OneToOne
    private Reservation reservation;

    private double amount;
    private boolean isPaid;

    // Constructors, getters, and setters
    public Bill() {
    }

    public Bill(Reservation reservation, double amount) {
        this.reservation = reservation;
        this.amount = amount;
        this.isPaid = false;
    }
  
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
