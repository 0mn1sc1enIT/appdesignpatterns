public class PayPalPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println(STR."Обработка оплаты через PayPal на сумму \{amount} тенге");
    }
}