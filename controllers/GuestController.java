@RequestMapping("/api/guests")
class GuestController {
    private final GuestService guestService;

    GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        return ResponseEntity.ok(guestService.getAllGuests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable int id) {
        return guestService.getGuestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(guestService.createGuest(guest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable int id, @RequestBody Guest guest) {
        try {
            return ResponseEntity.ok(guestService.updateGuest(id, guest));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable int id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}
