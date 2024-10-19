public class Main {
    public static void main(String[] args) {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        Order order = new Order(discountCalculator);

        order.addProduct(new Product("Laptop", 100000));
        order.addProduct(new Product("Mouse", 5000));

        order.setPaymentMethod(new CreditCardPayment());
        order.setDeliveryMethod(new CourierDelivery());
        order.setNotificationMethod(new EmailNotification());

        order.processOrder();
    }
}
