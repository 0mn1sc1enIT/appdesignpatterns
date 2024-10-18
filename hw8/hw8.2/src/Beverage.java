import java.util.Scanner;

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
