import java.util.ArrayList;
import java.util.List;

public class Order implements ICloneable<Order> {
    private List<Product> products;
    private double shippingCost;
    private List<Discount> discounts;
    private String paymentMethod;

    public Order() {
        products = new ArrayList<>();
        discounts = new ArrayList<>();
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }
    public List<Product> getProducts() {
        return products;
    }
    public double getShippingCost() {
        return shippingCost;
    }
    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }
    public List<Discount> getDiscounts() {
        return discounts;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public Order clone() {
        Order clonedOrder = new Order();
        clonedOrder.setShippingCost(this.shippingCost);
        clonedOrder.setPaymentMethod(this.paymentMethod);

        for (Product product : this.products) {
            clonedOrder.addProduct(product.clone());
        }

        for (Discount discount : this.discounts) {
            clonedOrder.addDiscount(discount.clone());
        }

        return clonedOrder;
    }
}
