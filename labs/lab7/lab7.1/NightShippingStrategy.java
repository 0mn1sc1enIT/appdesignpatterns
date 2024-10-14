import java.math.BigDecimal;

public class NightShippingStrategy implements IShippingStrategy {
    @Override
    public BigDecimal CalculateShippingCost(BigDecimal weight, BigDecimal distance) {
        return weight.multiply(new BigDecimal("0.7")).
                add(distance.multiply(new BigDecimal("0.3"))).
                add(new BigDecimal("20"));
    }
}
