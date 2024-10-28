package Decorators;

import Models.IBeverage;

public class BeverageDecorator implements IBeverage {
    protected IBeverage beverage;

    public BeverageDecorator(IBeverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public double GetCost() {
        return beverage.GetCost();
    }

    @Override
    public String GetDescription() {
        return beverage.GetDescription();
    }
}
