package Decorators;

import Beverages.IBeverage;
import Decorators.BeverageDecorator;

public class SugarDecorator extends BeverageDecorator {

    public SugarDecorator(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public double GetCost() {
        return this.beverage.GetCost() + 20d;
    }

    @Override
    public String GetDescription() {
        return STR."\{this.beverage.GetDescription()}, Sugar";
    }
}
