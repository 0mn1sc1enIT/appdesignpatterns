package Models;

public class Tea implements IBeverage {

    @Override
    public double GetCost() {
        return 40f;
    }

    @Override
    public String GetDescription() {
        return "Tea";
    }
}
