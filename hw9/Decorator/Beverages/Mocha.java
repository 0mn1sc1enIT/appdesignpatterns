package Beverages;

public class Mocha implements IBeverage {

    @Override
    public double GetCost() {
        return 600;
    }

    @Override
    public String GetDescription() {
        return "Mocha";
    }
}
