package Beverages;

public class Latte implements IBeverage {

    @Override
    public double GetCost() {
        return 840;
    }

    @Override
    public String GetDescription() {
        return "Latte";
    }
}