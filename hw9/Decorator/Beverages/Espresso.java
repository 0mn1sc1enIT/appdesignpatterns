package Beverages;

public class Espresso implements IBeverage {

    @Override
    public double GetCost() {
        return 550;
    }

    @Override
    public String GetDescription() {
        return "Espresso";
    }
}