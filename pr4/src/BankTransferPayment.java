public class BankTransferPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println(STR."Обработка оплаты банковским переводом на сумму \{amount} тенге");
    }
}