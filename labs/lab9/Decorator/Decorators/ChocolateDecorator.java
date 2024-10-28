package Decorators;

import Models.IBeverage;

public class ChocolateDecorator extends BeverageDecorator {
    public ChocolateDecorator(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public double GetCost() {
        return super.GetCost() + 15f;
    }
    @Override
    public String GetDescription() {
        return STR."\{super.GetDescription()}, Chocolate";
    }
}
