import java.util.ArrayList;
import java.util.List;

public class Main {
    enum RoomType {
        Suite,
        Apartment,
        Lux
    }
    class Room {
        private int roomNumber;
        private RoomType type;
        private boolean isAvailable;

        public Room(int roomNumber, RoomType type) {
            this.roomNumber = roomNumber;
            this.type = type;
            this.isAvailable = true;
        }

        public int getRoomNumber() {
            return roomNumber;
        }
        public RoomType getType() {
            return type;
        }
        public boolean isAvailable() {
            return isAvailable;
        }
        public void setAvailable(boolean available) {
            isAvailable = available;
        }
    }

    class Booking {
        private Room room;
        private String guestName;
        private String checkInDate;
        private String checkOutDate;

        public Booking(Room room, String guestName, String checkInDate, String checkOutDate) {
            this.room = room;
            this.guestName = guestName;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
            room.setAvailable(false);
        }

        public void cancel() {
            room.setAvailable(true);
        }
    }

    class Guest {
        private String name;

        public Guest(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void viewAvailableRooms(Hotel hotel) {
            hotel.showAvailableRooms();
        }

        public Booking bookRoom(Hotel hotel, int roomNumber, String checkIn, String checkOut) {
            return hotel.createBooking(this, roomNumber, checkIn, checkOut);
        }

        public void cancelBooking(Booking booking) {
            booking.cancel();
        }
    }

    class Admin {
        public void addRoom(Hotel hotel, int roomNumber, RoomType type) {
            hotel.addRoom(roomNumber, type);
        }

        public void deleteRoom(Hotel hotel, int roomNumber) {
            hotel.removeRoom(roomNumber);
        }
    }

    class Hotel {
        private List<Room> rooms = new ArrayList<>();
        private List<Booking> bookings = new ArrayList<>();

        public void addRoom(int roomNumber, RoomType type) {
            rooms.add(new Room(roomNumber, type));
        }

        public void removeRoom(int roomNumber) {
            rooms.removeIf(room -> room.getRoomNumber() == roomNumber);
        }

        public void showAvailableRooms() {
            for (Room room : rooms) {
                if (room.isAvailable()) {
                    System.out.println(STR."Room \{room.getRoomNumber()} (\{room.getType()}) is available.");
                }
            }
        }

        public Booking createBooking(Guest guest, int roomNumber, String checkIn, String checkOut) {
            for (Room room : rooms) {
                if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                    Booking booking = new Booking(room, guest.getName(), checkIn, checkOut);
                    bookings.add(booking);
                    return booking;
                }
            }
            return null;
        }
    }

    public void main(String[] args) {
        Hotel hotel = new Hotel();

        Admin admin = new Admin();
        admin.addRoom(hotel, 101, RoomType.Suite);
        admin.addRoom(hotel, 102, RoomType.Lux);
        admin.addRoom(hotel, 103, RoomType.Apartment);

        System.out.println("Доступные номера после добавления:");
        hotel.showAvailableRooms();

        Guest guest = new Guest("Иван Иванов");
        System.out.println("Гость просматривает доступные номера:");
        guest.viewAvailableRooms(hotel);

        System.out.println("Гость бронирует номер 101:");
        Booking booking = guest.bookRoom(hotel, 101, "2024-11-15", "2024-11-20");

        System.out.println("Доступные номера после бронирования:");
        hotel.showAvailableRooms();

        System.out.println("Гость отменяет бронирование номера 101:");
        guest.cancelBooking(booking);

        System.out.println("Доступные номера после отмены бронирования:");
        hotel.showAvailableRooms();

        System.out.println("Администратор удаляет номер 102:");
        admin.deleteRoom(hotel, 102);

        System.out.println("Доступные номера после удаления:");
        hotel.showAvailableRooms();
    }
}
