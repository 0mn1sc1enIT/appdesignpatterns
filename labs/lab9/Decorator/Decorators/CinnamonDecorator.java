package Decorators;

import Models.IBeverage;

public class CinnamonDecorator extends BeverageDecorator {

    public CinnamonDecorator(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public double GetCost() {
        return super.GetCost() + 18f;
    }
    @Override
    public String GetDescription() {
        return STR."\{super.GetDescription()}, Cinnamon";
    }
}
