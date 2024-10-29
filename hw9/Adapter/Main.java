public class Main {
    public static void main(String[] args) {
        IPaymentProcessor paypalProcessor = new PayPalPaymentProcessor();
        paypalProcessor.ProcessPayment(150d);

        StripePaymentService stripeService = new StripePaymentService();
        IPaymentProcessor stripeAdapter = new StripePaymentAdapter(stripeService);
        stripeAdapter.ProcessPayment(200d);

        AdyenPaymentService squareService = new AdyenPaymentService();
        IPaymentProcessor squareAdapter = new AdyenPaymentAdapter(squareService);
        squareAdapter.ProcessPayment(300d);
    }
}
