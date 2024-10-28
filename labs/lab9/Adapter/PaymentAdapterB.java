public class PaymentAdapterB implements IPaymentProcessor {
    private ExternalPaymentSystemB externalSystemB;

    public PaymentAdapterB(ExternalPaymentSystemB externalSystemB) {
        this.externalSystemB = externalSystemB;
    }
    @Override
    public void ProcessPayment(double amount) {
        externalSystemB.MakePayment(amount);
    }
    @Override
    public void RefundPayment(double amount) {
        externalSystemB.MakeRefund(amount);
    }
}
