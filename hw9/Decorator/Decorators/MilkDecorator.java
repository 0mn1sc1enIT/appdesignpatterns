package Decorators;

import Beverages.IBeverage;
import Decorators.BeverageDecorator;

public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public double GetCost() {
        return this.beverage.GetCost() + 50d;
    }

    @Override
    public String GetDescription() {
        return STR."\{this.beverage.GetDescription()}, Milk";
    }
}
