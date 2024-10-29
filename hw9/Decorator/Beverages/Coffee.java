package Beverages;

public class Coffee implements IBeverage {
    @Override
    public double GetCost() {
        return 500;
    }

    @Override
    public String GetDescription() {
        return "Coffee";
    }
}
