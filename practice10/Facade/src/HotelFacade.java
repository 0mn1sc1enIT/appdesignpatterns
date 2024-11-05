import java.util.Scanner;

public class HotelFacade {
    private RoomBookingSystem roomBookingSystem;
    private RestaurantSystem restaurantSystem;
    private EventManagementSystem eventManagementSystem;
    private CleaningService cleaningService;

    public HotelFacade(RoomBookingSystem roomBookingSystem, RestaurantSystem restaurantSystem,
                       EventManagementSystem eventManagementSystem, CleaningService cleaningService) {
        this.roomBookingSystem = roomBookingSystem;
        this.restaurantSystem = restaurantSystem;
        this.eventManagementSystem = eventManagementSystem;
        this.cleaningService = cleaningService;
    }

    public void BookingRoom() {
        roomBookingSystem.Reservation(23);
        restaurantSystem.OrderFood();
        cleaningService.DoCleaning();
    }

    public void EventOrganization() {
        roomBookingSystem.Reservation(201);
        roomBookingSystem.Reservation(202);
        roomBookingSystem.Reservation(203);
        eventManagementSystem.OrderEquipment();
    }

    public void TableReservation() {
        restaurantSystem.Reservation(4);
        restaurantSystem.OrderFood();
        restaurantSystem.OrderTaxi(23);
    }
}
