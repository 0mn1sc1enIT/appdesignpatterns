package Decorators;

import Beverages.IBeverage;

public abstract class BeverageDecorator implements IBeverage {
    protected IBeverage beverage;

    public BeverageDecorator(IBeverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public double GetCost() {
        return this.beverage.GetCost();
    }

    @Override
    public String GetDescription() {
        return this.beverage.GetDescription();
    }
}
