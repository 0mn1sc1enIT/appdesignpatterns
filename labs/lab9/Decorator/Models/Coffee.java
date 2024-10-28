package Models;

public class Coffee implements IBeverage {

    @Override
    public double GetCost() {
        return 50f;
    }

    @Override
    public String GetDescription() {
        return "Coffee";
    }
}
