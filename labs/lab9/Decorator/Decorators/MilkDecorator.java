package Decorators;

import Models.IBeverage;

public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public double GetCost() {
        return super.GetCost() + 10f;
    }
    @Override
    public String GetDescription() {
        return STR."\{super.GetDescription()}, Milk";
    }
}
