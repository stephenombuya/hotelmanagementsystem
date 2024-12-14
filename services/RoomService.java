@Service
class RoomService {
    private final RoomRepository roomRepository;

    RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(int id) {
        return roomRepository.findById(id);
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }

    public Room updateRoom(int id, Room updatedRoom) {
        return roomRepository.findById(id).map(room -> {
            room.setRoomNumber(updatedRoom.getRoomNumber());
            room.setType(updatedRoom.getType());
            room.setAvailable(updatedRoom.isAvailable());
            return roomRepository.save(room);
        }).orElseThrow(() -> new RuntimeException("Room not found"));
    }
}
