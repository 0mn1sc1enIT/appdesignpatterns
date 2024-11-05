import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RestaurantSystem {
    int table;
    List<Integer> tables = new ArrayList<>();

    public RestaurantSystem() {
        Main.Fill(this.tables, 1, 15);
    }

    public void Reservation(int table) {
        this.table = table;

        if (tables.contains(table)) {
            System.out.println("Ваш столик готов!");
            tables.remove(Integer.valueOf(this.table));
        } else {
            System.out.println("К сожалению данный столик занят, выберите другой");
        }
    }

    public void OrderTaxi(int minutes) {
        System.out.println("Через сколько подъехать такси? (в минутах)");
        System.out.println(STR."Такси прибудет через \{formatMinutes(minutes)}");
    }

    private static String formatMinutes(int minutes) {
        int lastDigit = minutes % 10;
        int lastTwoDigits = minutes % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 19) {
            return STR."\{minutes} минут";
        }
        switch (lastDigit) {
            case 1:
                return STR."\{minutes} минута";
            case 2:
            case 3:
            case 4:
                return STR."\{minutes} минуты";
            default:
                return STR."\{minutes} минут";
        }
    }

    public void CancelReservation() {
        if (!tables.contains(this.table)) {
            System.out.println("Спасибо за визит! До свидания!");
            tables.add(this.table);
        } else {
            System.out.println("Бронь уже была отменена");
        }
    }

    public void OrderFood() {
        List<String> menu = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Что будете заказывать?");
        String choice = scan.next();
        while (!Objects.equals(choice, "Все")) {
            menu.add(choice);
            choice = scan.next();
        }
        String order = String.join(" ", menu);
        System.out.println(STR."Ваш заказ: \{order} будет готов через 40 минут");
    }
}
