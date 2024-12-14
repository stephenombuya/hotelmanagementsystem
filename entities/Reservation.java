@Entity
class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    @ManyToOne
    private Guest guest;

    @ManyToOne
    private Room room;

    private Date checkInDate;
    private Date checkOutDate;
    private boolean isCheckedIn;
    private boolean isCheckedOut;

    // Constructors, getters, and setters
    public Reservation() {
    }
  
    public Reservation(Guest guest, Room room, Date checkInDate, Date checkOutDate) {
          this.guest = guest;
          this.room = room;
          this.checkInDate = checkInDate;
          this.checkOutDate = checkOutDate;
          this.isCheckedIn = false;
          this.isCheckedOut = false;
      }
  
      public int getReservationId() {
          return reservationId;
      }
  
      public void setReservationId(int reservationId) {
          this.reservationId = reservationId;
      }
  
      public Guest getGuest() {
          return guest;
      }
  
      public void setGuest(Guest guest) {
          this.guest = guest;
      }
  
      public Room getRoom() {
          return room;
      }
       public void setRoom(Room room) {
          this.room = room;
      }
  
      public Date getCheckInDate() {
          return checkInDate;
      }
  
      public void setCheckInDate(Date checkInDate) {
          this.checkInDate = checkInDate;
      }
  
      public Date getCheckOutDate() {
          return checkOutDate;
      }
  
      public void setCheckOutDate(Date checkOutDate) {
          this.checkOutDate = checkOutDate;
      }
  
      public boolean isCheckedIn() {
          return isCheckedIn;
      }
  
      public void setCheckedIn(boolean checkedIn) {
          isCheckedIn = checkedIn;
      }
  
      public boolean isCheckedOut() {
          return isCheckedOut;
      }
  
      public void setCheckedOut(boolean checkedOut) {
          isCheckedOut = checkedOut;
      }
  }
