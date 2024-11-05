import java.util.ArrayList;
import java.util.List;

public class RoomBookingSystem {
    int room;
    List<Integer> rooms = new ArrayList<>();

    public RoomBookingSystem() {
        Main.Fill(this.rooms, 20, 234);;
    }
    public void Reservation(int room) {
        this.room = room;
        Available();
        if (rooms.contains(this.room)) {
            System.out.println("Возьмите ключи от вашей комнаты");
            rooms.remove(Integer.valueOf(this.room));
        }
    }

    public void Available() {
        boolean isAvailable = rooms.contains(this.room);
        if (isAvailable) {
            System.out.println("Комната доступна для резервирования");
        } else {
            System.out.println("К сожалению на данный момент комната занята");
        }
    }

    public void CancelReservation() {
        if (!rooms.contains(this.room)) {
            rooms.add(this.room);
            System.out.println("Благодарим за визит. Приходите еше!");
        } else {
            System.out.println("Бронь уже была отменена");
        }
    }
}
