public class DiscountCalculator {
    public double applyDiscount(double totalAmount) {
        double discount = 0.1;
        return (1 - discount) * totalAmount;
    }
}
