import java.util.Scanner;

public class Coffee extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Завариваем кофе...");
    }

    @Override
    protected void addCondiments() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Хотите добавить сахар? y/n");
        String choice = scan.next();
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Добавляем сахар...");
        }
        System.out.println("Хотите добавить молоко? y/n");
        choice = scan.next();
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Добавляем молоко...");
        }
        System.out.println("Хотите добавить шоколад? y/n");
        choice = scan.next();
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Добавляем шоколад...");
        }
    }
}
