package DIP;

public class Main {
    public interface MessageSender {
        public void sendMessage(String message);
    }

    public class EmailSender implements MessageSender {
        @Override
        public void sendMessage(String message) {
            System.out.println("Email sent: " + message);
        }
    }

    public class SmsSender implements MessageSender {
        @Override
        public void sendMessage(String message) {
            System.out.println("SMS sent: " + message);
        }
    }

    public class NotificationService {
        private MessageSender emailSender = new EmailSender();
        private MessageSender smsSender = new EmailSender();

        public void sendNotification(String message) {
            emailSender.sendMessage(message);
            smsSender.sendMessage(message);
        }
    }
}
