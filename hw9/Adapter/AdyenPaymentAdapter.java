public class AdyenPaymentAdapter implements IPaymentProcessor {
    private AdyenPaymentService adyenPaymentService;
    public AdyenPaymentAdapter(AdyenPaymentService adyenPaymentService) {
        this.adyenPaymentService = adyenPaymentService;
    }
    @Override
    public void ProcessPayment(double amount) {
        adyenPaymentService.MakePayment(amount);
    }
}
