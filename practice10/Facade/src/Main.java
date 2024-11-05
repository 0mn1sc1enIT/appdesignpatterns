import java.util.List;

public class Main {
    public static void main(String[] args) {
        RoomBookingSystem roomBookingSystem = new RoomBookingSystem();
        RestaurantSystem restaurantSystem = new RestaurantSystem();
        EventManagementSystem eventManagementSystem = new EventManagementSystem();
        CleaningService cleaningService = new CleaningService();

        HotelFacade hotelFacade = new HotelFacade(roomBookingSystem, restaurantSystem, eventManagementSystem, cleaningService);

        hotelFacade.BookingRoom();
        System.out.println();
        hotelFacade.EventOrganization();
        System.out.println();
        hotelFacade.TableReservation();
    }

    static void Fill(List<Integer> arr, int min, int max) {
        for (int i = min; i <= max; i++) {
            arr.add(i);
        }
    }
}
