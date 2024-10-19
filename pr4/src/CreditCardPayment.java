public class CreditCardPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println(STR."Обработка оплаты кредитной картой на сумму \{amount} тенге");
    }
}
