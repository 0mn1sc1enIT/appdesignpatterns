package SRP;

public class Order {
    public String ProductName;
    public int Quantity;
    public double price;

    public Order(String ProductName, int Quantity, double price) {
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.price = price;
    }

    public double calculateTotalPrice() {
        // Рассчет стоимости с учетом скидок
        return Quantity * price * 0.9;
    }
}
