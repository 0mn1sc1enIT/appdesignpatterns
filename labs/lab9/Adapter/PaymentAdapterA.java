public class PaymentAdapterA implements IPaymentProcessor {
    private ExternalPaymentSystemA externalSystemA;

    public PaymentAdapterA(ExternalPaymentSystemA externalSystemA) {
        this.externalSystemA = externalSystemA;
    }
    @Override
    public void ProcessPayment(double amount) {
        externalSystemA.MakePayment(amount);
    }

    @Override
    public void RefundPayment(double amount) {
        externalSystemA.MakeRefund(amount);
    }
}
