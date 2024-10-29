package Decorators;

import Beverages.IBeverage;

public class LemonDecorator extends BeverageDecorator {
    public LemonDecorator(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public double GetCost() {
        return this.beverage.GetCost() + 30d;
    }

    @Override
    public String GetDescription() {
        return STR."\{this.beverage.GetDescription()}, Lemon";
    }
}
