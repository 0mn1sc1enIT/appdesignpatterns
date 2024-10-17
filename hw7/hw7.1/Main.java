import java.math.BigDecimal;

public class Main {
    public interface IPaymentStrategy {
        void Pay(BigDecimal amount);
    }

    class PayPalPayment implements IPaymentStrategy {
        private BigDecimal balance = new BigDecimal("23000");
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }
        @Override
        public void Pay(BigDecimal amount) {
            System.out.println(STR."Идет оплата \{amount} через Paypal: \{email}...");
            if (balance.subtract(amount).compareTo(new BigDecimal("0")) > 0) {
                balance = balance.subtract(amount);
                System.out.println("Оплата прошла успешно!");
                System.out.println(STR."Текущий баланс: \{balance}");
            } else {
                System.out.println("Недостаточно средств");
            }
        }
    }

    class CryptoPayment implements IPaymentStrategy {
        private BigDecimal balance = new BigDecimal("5");
        private String wallet;

        public CryptoPayment(String wallet) {
            this.wallet = wallet;
        }
        @Override
        public void Pay(BigDecimal amount) {
            System.out.println(STR."Идет оплата \{amount} через криптовалюту \{wallet}...");
            if (balance.subtract(amount).compareTo(new BigDecimal("0")) > 0) {
                balance = balance.subtract(amount);
                System.out.println("Оплата прошла успешно!");
                System.out.println(STR."Текущий баланс: \{balance}");
            } else {
                System.out.println("Недостаточно средств");
            }
        }
    }

    class CreditCardPayment implements IPaymentStrategy {
        private BigDecimal balance = new BigDecimal("10000000");
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }
        @Override
        public void Pay(BigDecimal amount) {
            System.out.println(STR."Идет оплата \{amount} через банковскую карту \{cardNumber}");
            if (balance.subtract(amount).compareTo(new BigDecimal("0")) > 0) {
                balance = balance.subtract(amount);
                System.out.println("Оплата прошла успешно!");
                System.out.println(STR."Текущий баланс: \{balance}");
            } else {
                System.out.println("Недостаточно средств");
            }
        }
    }

    public class PaymentContext {
        private IPaymentStrategy paymentStrategy;

        public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(BigDecimal amount) {
            if (paymentStrategy != null) {
                paymentStrategy.Pay(amount);
            } else {
                System.out.println("Способ оплаты не выбран.");
            }
        }
    }

    public void main(String[] args) {
        PaymentContext context = new PaymentContext();

        IPaymentStrategy cardPayment = new CreditCardPayment("1234-5678-9876-5432");
        context.setPaymentStrategy(cardPayment);
        context.executePayment(new BigDecimal("150000"));

        IPaymentStrategy paypalPayment = new PayPalPayment("user1@paypal.pp");
        context.setPaymentStrategy(paypalPayment);
        context.executePayment(new BigDecimal("3450"));

        IPaymentStrategy cryptoPayment = new CryptoPayment("1CryptoWalletXYZ");
        context.setPaymentStrategy(cryptoPayment);
        context.executePayment(new BigDecimal("0.045"));
    }
}
