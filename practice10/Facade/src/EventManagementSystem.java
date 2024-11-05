import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class EventManagementSystem {
    public void OrderHall() {
        Random rand = new Random();
        System.out.println(STR."Ваш конференц-зал: \{rand.nextInt(3) + 1}");
    }

    public void OrderEquipment() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберите оборудование, которое хотите заказать");
        String equip = scan.nextLine();
        System.out.println(STR."Вы заказали следующее оборудование: \{equip}");
    }

}
