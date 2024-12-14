@Service
class GuestService {
    private final GuestRepository guestRepository;

    GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Optional<Guest> getGuestById(int id) {
        return guestRepository.findById(id);
    }

    public Guest createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void deleteGuest(int id) {
        guestRepository.deleteById(id);
    }

    public Guest updateGuest(int id, Guest updatedGuest) {
        return guestRepository.findById(id).map(guest -> {
            guest.setName(updatedGuest.getName());
            guest.setEmail(updatedGuest.getEmail());
            return guestRepository.save(guest);
        }).orElseThrow(() -> new RuntimeException("Guest not found"));
    }
}
