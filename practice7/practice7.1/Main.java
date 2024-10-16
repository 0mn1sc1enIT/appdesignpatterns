import java.math.BigDecimal;

public class Main {
    public enum ServiceClass {
        First,
        Second
    }
    public interface ICostCalculationStrategy {
        BigDecimal Cost(int passengers, ServiceClass serviceClass, boolean hasDiscount, boolean hasBaggage);
    }
    public class AirplaneCost implements ICostCalculationStrategy {
        @Override
        public BigDecimal Cost(int passengers, ServiceClass serviceClass, boolean hasDiscount, boolean hasBaggage) {
            BigDecimal cost;
            switch (serviceClass) {
                case ServiceClass.First:
                    cost = new BigDecimal("10000").multiply(new BigDecimal(passengers));
                    break;
                case ServiceClass.Second:
                    cost = new BigDecimal("7500").multiply(new BigDecimal(passengers));
                    break;
                default:
                    throw new IllegalArgumentException("something went wrong");
            }
            if (!hasDiscount && !hasBaggage) {
                return cost;
            }
            if (hasDiscount) {
                cost = cost.multiply(new BigDecimal("0.8"));
            }
            if (hasBaggage) {
                cost = cost.add(new BigDecimal("1000"));
            }
            return cost;
        }
    }

    public class TrainCost implements ICostCalculationStrategy {
        @Override
        public BigDecimal Cost(int passengers, ServiceClass serviceClass, boolean hasDiscount, boolean hasBaggage) {
            BigDecimal cost;
            switch (serviceClass) {
                case ServiceClass.First:
                    cost = new BigDecimal("2000").multiply(new BigDecimal(passengers));
                    break;
                case ServiceClass.Second:
                    cost = new BigDecimal("1500").multiply(new BigDecimal(passengers));
                    break;
                default:
                    throw new IllegalArgumentException("something went wrong");
            }
            if (!hasDiscount && !hasBaggage) {
                return cost;
            }
            if (hasDiscount) {
                cost = cost.multiply(new BigDecimal("0.7"));
            }
            if (hasBaggage) {
                cost = cost.add(new BigDecimal("500"));
            }
            return cost;
        }
    }
    public class BusCost implements ICostCalculationStrategy {
        @Override
        public BigDecimal Cost(int passengers, ServiceClass serviceClass, boolean hasDiscount, boolean hasBaggage) {
            BigDecimal cost;
            switch (serviceClass) {
                case ServiceClass.First:
                    cost = new BigDecimal("120").multiply(new BigDecimal(passengers));
                    break;
                case ServiceClass.Second:
                    cost = new BigDecimal("60").multiply(new BigDecimal(passengers));
                    break;
                default:
                    throw new IllegalArgumentException("something went wrong");
            }
            if (!hasDiscount && !hasBaggage) {
                return cost;
            }
            if (hasDiscount) {
                cost = cost.multiply(new BigDecimal("0.5"));
            }
            if (hasBaggage) {
                cost = cost.add(new BigDecimal("50"));
            }
            return cost;
        }
    }

    public class CarCost implements ICostCalculationStrategy {
        @Override
        public BigDecimal Cost(int passengers, ServiceClass serviceClass, boolean hasDiscount, boolean hasBaggage) {
            BigDecimal cost;
            switch (serviceClass) {
                case ServiceClass.First:
                    cost = new BigDecimal("500").multiply(new BigDecimal(passengers));
                    break;
                case ServiceClass.Second:
                    cost = new BigDecimal("300").multiply(new BigDecimal(passengers));
                    break;
                default:
                    throw new IllegalArgumentException("Неверный класс обслуживания");
            }
            if (!hasDiscount && !hasBaggage) {
                return cost;
            }
            if (hasDiscount) {
                cost = cost.multiply(new BigDecimal("0.9"));
            }
            if (hasBaggage) {
                cost = cost.add(new BigDecimal("200"));
            }
            return cost;
        }
    }

    public class TravelBookingContext {
        private ICostCalculationStrategy costCalculation;
        public TravelBookingContext(ICostCalculationStrategy costCalculation) {
            this.costCalculation = costCalculation;
        }
        public void ChangeTravelCost(ICostCalculationStrategy costCalculation) {
            this.costCalculation = costCalculation;
        }
        public BigDecimal getTravelCost(int passengers, ServiceClass serviceClass, boolean hasDiscount, boolean hasBaggage) {
            if (passengers <= 0) {
                throw new IllegalArgumentException("Некорректное значение количества пассажиров");
            }
            return this.costCalculation.Cost(passengers, serviceClass, hasDiscount, hasBaggage);
        }
    }
    public void main(String[] args) {
        TravelBookingContext context = new TravelBookingContext(new AirplaneCost());
        System.out.println(context.getTravelCost(0, ServiceClass.First, true, false));

        context.ChangeTravelCost(new BusCost());
        System.out.println(context.getTravelCost(5, ServiceClass.Second, false, true));

        context.ChangeTravelCost(new CarCost());
        System.out.println(context.getTravelCost(1, ServiceClass.First, true, true));

        context.ChangeTravelCost(new TrainCost());
        System.out.println(context.getTravelCost(2, ServiceClass.Second, false, true));
    }
}
