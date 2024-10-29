import Beverages.*;
import Decorators.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        IBeverage beverage;
        Map<Integer, String> additions = new HashMap<>();

        System.out.println("Выберите напиток: (1 - Кофе) (2 - Чай) (3 - Латте) (4 - Мокко) (5 - Эспрессо)");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                beverage = new Coffee();
                additions.put(1, "Milk");
                additions.put(2, "Sugar");
                break;
            case 2:
                beverage = new Tea();
                additions.put(1, "Milk");
                additions.put(2, "Sugar");
                additions.put(3, "Lemon");
                break;
            case 3:
                beverage = new Latte();
                additions.put(2, "Sugar");
                additions.put(4, "WhippedCream");
                additions.put(5, "Chocolate");
            case 4:
                beverage = new Mocha();
                additions.put(1, "Milk");
                additions.put(2, "Sugar");
                additions.put(4, "WhippedCream");
                additions.put(5, "Chocolate");
            case 5:
                beverage = new Espresso();
                additions.put(2, "Sugar");
                additions.put(4, "WhippedCream");
                additions.put(1, "Milk");
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
                        beverage = new LemonDecorator(beverage);
                        additions.remove(3);
                    }
                    break;
                case 4:
                    if (additions.containsKey(4)) {
                        beverage = new WhippedCreamDecorator(beverage);
                        additions.remove(4);
                    }
                    break;
                case 5:
                    if (additions.containsKey(5)) {
                        beverage = new ChocolateDecorator(beverage);
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
    }
}
