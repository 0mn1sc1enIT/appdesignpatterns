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
