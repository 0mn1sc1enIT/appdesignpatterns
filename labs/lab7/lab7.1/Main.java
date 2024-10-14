import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DeliveryContext deliveryContext = new DeliveryContext();
        System.out.println("Выберите тип доставки: 1 - Стандартная, 2 - Экспресс, 3 - Международная, 4 - Ночная");
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();

        switch (choice) {
            case "1":
                deliveryContext.SetShippingStrategy(new StandardShippingStrategy());
                break;
            case "2":
                deliveryContext.SetShippingStrategy(new ExpressShippingStrategy());
                break;
            case "3":
                deliveryContext.SetShippingStrategy(new InternationalShippingStrategy());
                break;
            case "4":
                deliveryContext.SetShippingStrategy(new NightShippingStrategy());
                break;
            default:
                System.out.println("Неверный выбор");
                return;
        }

        System.out.println("Введите вес посылки (кг):");
        BigDecimal weight = new BigDecimal(scan.next());
        System.out.println("Введите расстояние доставки (км):");
        BigDecimal distance = new BigDecimal(scan.next());

        if (weight.intValue() <= 0 || distance.intValue() <= 0) {
            System.out.println("Неправильный ввод");
            return;
        }
        BigDecimal cost = deliveryContext.CalculateCost(weight, distance);
        System.out.println(STR."Стоимость доставки: \{cost}");
    }
}
