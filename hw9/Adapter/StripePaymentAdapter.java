class StripePaymentAdapter implements IPaymentProcessor {
    private StripePaymentService stripePaymentService;

    public StripePaymentAdapter(StripePaymentService stripePaymentService) {
        this.stripePaymentService = stripePaymentService;
    }
    @Override
    public void ProcessPayment(double amount) {
        stripePaymentService.MakeTransaction(amount);
    }
}