package Beverages;

public class Tea implements IBeverage {

    @Override
    public double GetCost() {
        return 400;
    }

    @Override
    public String GetDescription() {
        return "Tea";
    }
}
