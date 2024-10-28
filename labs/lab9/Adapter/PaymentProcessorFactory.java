public class PaymentProcessorFactory {
    public static IPaymentProcessor getPaymentProcessor(String currency, String region) {
        if (region.equals("US") || currency.equals("USD")) {
            return new InternalPaymentProcessor();
        } else if (region.equals("EU") || currency.equals("EUR")) {
            return new PaymentAdapterA(new ExternalPaymentSystemA());
        } else if (region.equals("Asia")) {
            return new PaymentAdapterB(new ExternalPaymentSystemB());
        } else {
            throw new IllegalArgumentException(STR."No suitable payment processor found for currency: \{currency} and region: \{region}");
        }
    }
}
