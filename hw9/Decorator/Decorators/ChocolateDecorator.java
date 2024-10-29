package Decorators;

import Beverages.IBeverage;

public class ChocolateDecorator extends BeverageDecorator {
    public ChocolateDecorator(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public double GetCost() {
        return this.beverage.GetCost() + 120d;
    }

    @Override
    public String GetDescription() {
        return STR."\{this.beverage.GetDescription()}, Chocolate";
    }
}
