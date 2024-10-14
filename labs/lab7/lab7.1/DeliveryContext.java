import java.math.BigDecimal;

public class DeliveryContext {
    private IShippingStrategy shippingStrategy;
    public void SetShippingStrategy(IShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }
    public BigDecimal CalculateCost(BigDecimal weight, BigDecimal distance) {
        if (this.shippingStrategy == null) {
            throw new IllegalStateException("Стратегия доставки не установлена");
        }
        return shippingStrategy.CalculateShippingCost(weight, distance);
    }
}
