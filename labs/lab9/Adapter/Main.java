public class Main {
    public static void main(String[] args) {
        IPaymentProcessor processorUS = PaymentProcessorFactory.getPaymentProcessor("USD", "US");
        processorUS.ProcessPayment(100.0);
        processorUS.RefundPayment(50.0);

        IPaymentProcessor processorEU = PaymentProcessorFactory.getPaymentProcessor("EUR", "EU");
        processorEU.ProcessPayment(200.0);
        processorEU.RefundPayment(75.0);

        IPaymentProcessor processorAsia = PaymentProcessorFactory.getPaymentProcessor("JPY", "Asia");
        processorAsia.ProcessPayment(300.0);
        processorAsia.RefundPayment(125.0);
    }
}
