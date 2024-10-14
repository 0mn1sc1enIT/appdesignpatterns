import java.math.BigDecimal;

public class StandardShippingStrategy implements IShippingStrategy {
    @Override
    public BigDecimal CalculateShippingCost(BigDecimal weight, BigDecimal distance) {
        return weight.multiply(new BigDecimal("0.5")).
                add(distance.multiply(new BigDecimal("0.1")));
    }
}
