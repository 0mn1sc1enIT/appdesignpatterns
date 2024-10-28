package Decorators;

import Models.IBeverage;

public class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public double GetCost() {
        return super.GetCost() + 5f;
    }
    @Override
    public String GetDescription() {
        return STR."\{super.GetDescription()}, Sugar";
    }
}
