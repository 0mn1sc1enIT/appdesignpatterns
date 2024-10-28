import Decorators.*;
import Models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        IBeverage beverage;
        Map<Integer, String> additions = new HashMap<>();

        System.out.println("Выберите напиток: (1 - Кофе) (2 - Чай)");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                beverage = new Coffee();
                additions.put(1, "Milk");
                additions.put(2, "Sugar");
                additions.put(3, "Chocolate");
                additions.put(4, "Vanilla");
                additions.put(5, "Cinnamon");
                break;
            case 2:
                beverage = new Tea();
                additions.put(1, "Milk");
                additions.put(2, "Sugar");
                additions.put(3, "Lemon");
                additions.put(4, "Cinnamon");
                break;
            default:
                System.out.println("Такого напитка нет в продаже");
                return;
        }

        boolean add = true;
        while (add && !additions.isEmpty()) {
            System.out.print("Выберите добавку ");
            additions.forEach((key, value) -> System.out.print(STR."(\{key} - \{value}) "));
            System.out.print("(0 - Закончить): ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    if (additions.containsKey(1)) {
                        beverage = new MilkDecorator(beverage);
                        additions.remove(1);
                    }
                    break;
                case 2:
                    if (additions.containsKey(2)) {
                        beverage = new SugarDecorator(beverage);
                        additions.remove(2);
                    }
                    break;
                case 3:
                    if (additions.containsKey(3)) {
                        beverage = new ChocolateDecorator(beverage);
                        additions.remove(3);
                    }
                    break;
                case 4:
                    if (additions.containsKey(4)) {
                        beverage = new VanillaDecorator(beverage);
                        additions.remove(4);
                    }
                    break;
                case 5:
                    if (additions.containsKey(5)) {
                        beverage = new CinnamonDecorator(beverage);
                        additions.remove(5);
                    }
                    break;
                case 0:
                    add = false;
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
        System.out.println(STR."\{beverage.GetDescription()} : \{beverage.GetCost()}");

        scan.close();
    }
}
