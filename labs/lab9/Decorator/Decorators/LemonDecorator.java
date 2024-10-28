package Decorators;

import Models.IBeverage;

public class LemonDecorator extends BeverageDecorator {

    public LemonDecorator(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public double GetCost() {
        return super.GetCost() + 6f;
    }
    @Override
    public String GetDescription() {
        return STR."\{super.GetDescription()}, Lemon";
    }
}
