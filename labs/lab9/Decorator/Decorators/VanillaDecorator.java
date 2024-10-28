package Decorators;

import Models.IBeverage;

public class VanillaDecorator extends BeverageDecorator {
    public VanillaDecorator(IBeverage beverage) {
        super(beverage);
    }
    @Override
    public double GetCost() {
        return super.GetCost() + 8f;
    }
    @Override
    public String GetDescription() {
        return STR."\{super.GetDescription()}, Vanilla";
    }
}
