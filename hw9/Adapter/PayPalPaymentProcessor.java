public class PayPalPaymentProcessor implements IPaymentProcessor {
    @Override
    public void ProcessPayment(double amount) {
        System.out.println(STR."Обработка платежа через PayPal: \{amount}$");
    }
}
