public class Main {
    public static void main(String[] args) {
        Order originalOrder = new Order();
        originalOrder.setShippingCost(5.99);
        originalOrder.setPaymentMethod("Credit Card");
        originalOrder.addProduct(new Product("Laptop", 999.99, 1));
        originalOrder.addProduct(new Product("Mouse", 25.50, 2));
        originalOrder.addDiscount(new Discount(10)); // 10% скидка

        Order clonedOrder = originalOrder.clone();

        clonedOrder.setShippingCost(7.99);
        clonedOrder.addProduct(new Product("Keyboard", 45.00, 1));
        clonedOrder.addDiscount(new Discount(5)); // 5% скидка

        System.out.println("Оригинальный заказ:");
        printOrder(originalOrder);
        System.out.println("\nКлонированный заказ:");
        printOrder(clonedOrder);
    }

    private static void printOrder(Order order) {
        System.out.println(STR."Метод оплаты: \{order.getPaymentMethod()}");
        System.out.println(STR."Стоимость доставки: \{order.getShippingCost()}");
        System.out.println("Товары:");
        for (Product product : order.getProducts()) {
            System.out.println(STR."- \{product.getName()} (Цена: \{product.getPrice()}, Количество: \{product.getQuantity()})");
        }
        System.out.println("Скидки:");
        for (Discount discount : order.getDiscounts()) {
            System.out.println(STR."- \{discount.getPercentage()}%");
        }
    }
}
