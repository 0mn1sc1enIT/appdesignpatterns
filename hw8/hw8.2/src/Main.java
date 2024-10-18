public class Main {
    public static void main(String[] args) {
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
