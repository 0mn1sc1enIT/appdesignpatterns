import java.math.BigDecimal;

public class ExpressShippingStrategy implements IShippingStrategy {

    @Override
    public BigDecimal CalculateShippingCost(BigDecimal weight, BigDecimal distance) {
        return weight.multiply(new BigDecimal("0.75")).
                add(distance.multiply(new BigDecimal("0.2"))).
                add(new BigDecimal("10"));
    }
}
