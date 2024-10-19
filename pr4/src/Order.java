import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();
    private IPayment paymentMethod;
    private IDelivery deliveryMethod;
    private INotification notificationMethod;
    private DiscountCalculator discountCalculator;

    public Order(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return discountCalculator.applyDiscount(total);
    }

    public void setPaymentMethod(IPayment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDeliveryMethod(IDelivery deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public void setNotificationMethod(INotification notificationMethod) {
        this.notificationMethod = notificationMethod;
    }

    public void processOrder() {
        double totalAmount = calculateTotal();
        paymentMethod.processPayment(totalAmount);
        deliveryMethod.deliverOrder(this);
        notificationMethod.sendNotification("Ваш заказ успешно обработан!");
    }

    public List<Product> getProducts() {
        return products;
    }
}
