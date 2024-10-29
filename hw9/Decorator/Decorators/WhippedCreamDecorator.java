package Decorators;

import Beverages.IBeverage;
import Decorators.BeverageDecorator;

public class WhippedCreamDecorator extends BeverageDecorator {
    public WhippedCreamDecorator(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public double GetCost() {
        return this.beverage.GetCost() + 100d;
    }

    @Override
    public String GetDescription() {
        return STR."\{this.beverage.GetDescription()}, WhippedCream";
    }
}
