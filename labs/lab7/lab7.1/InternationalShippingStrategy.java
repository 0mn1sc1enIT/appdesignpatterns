import java.math.BigDecimal;

public class InternationalShippingStrategy implements IShippingStrategy {
    @Override
    public BigDecimal CalculateShippingCost(BigDecimal weight, BigDecimal distance) {
        return weight.multiply(new BigDecimal("1")).
                add(distance.multiply(new BigDecimal("0.5"))).
                add(new BigDecimal("15"));
    }
}
