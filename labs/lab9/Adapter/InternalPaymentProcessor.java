public class InternalPaymentProcessor implements IPaymentProcessor {

    @Override
    public void ProcessPayment(double amount) {
        System.out.println(STR."Processing payment of \{amount} via internal system");
    }

    @Override
    public void RefundPayment(double amount) {
        System.out.println(STR."Refunding payment of \{amount} via internal system");
    }
}
