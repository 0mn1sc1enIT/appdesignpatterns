public class Discount implements ICloneable<Discount> {
    private double percentage;

    public Discount(double percentage) {
        this.percentage = percentage;
    }

    // Геттер
    public double getPercentage() {
        return percentage;
    }

    @Override
    public Discount clone() {
        return new Discount(this.percentage);
    }
}
