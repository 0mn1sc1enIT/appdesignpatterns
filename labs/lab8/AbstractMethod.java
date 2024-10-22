import java.util.Scanner;

public class AbstractMethod {
    public abstract class Beverage {
        private boolean sugar;
        private boolean milk;
        public final void prepareBeverage() {
            addWater();
            boilWater();
            brew();
            if (customerWantsCondiments()) {
                addCondiments();
            }
        }

        private void addWater() {
            System.out.println("Заливаем воду...");
        }

        private void boilWater() {
            System.out.println("Кипятим воду...");
        }

        protected abstract void brew();

        protected abstract void addCondiments();

        protected boolean customerWantsCondiments() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Хотите добавки? y/n");
            String choice = scan.next();
            return choice.equalsIgnoreCase("y");
        }
    }
    public class HotChocolate extends Beverage {
        @Override
        protected void brew() {
            System.out.println("Размешиваем горячий шоколад....");
        }

        @Override
        protected void addCondiments() {
            System.out.println("Добавляем взбитые сливки...");
        }
    }
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
    public void main(String[] args) {
        System.out.println("Готовим чай...");
        Beverage tea = new Tea();
        tea.prepareBeverage();

        System.out.println("\nГотовим кофе...");
        Beverage coffee = new Coffee();
        coffee.prepareBeverage();

        System.out.println("\nГотовим горячий шоколад...");
        Beverage hotChocolate = new HotChocolate();
        hotChocolate.prepareBeverage();
    }
}
