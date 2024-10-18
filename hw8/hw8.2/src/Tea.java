import java.util.Scanner;

public class Tea extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Завариваем чай...");
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
        boolean b = choice.equalsIgnoreCase("y");
        if (choice.equalsIgnoreCase("y")) {
            System.out.println("Добавляем молоко...");
        }
        if (b) {
            System.out.println("Хотите добавить лимон? y/n");
            choice = scan.next();
            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Добавляем лимон...");
            }
        }
    }
}
