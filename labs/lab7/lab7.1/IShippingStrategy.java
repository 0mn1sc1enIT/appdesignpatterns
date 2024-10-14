import java.math.BigDecimal;

public interface IShippingStrategy {
    BigDecimal CalculateShippingCost(BigDecimal weight, BigDecimal distance);
}
