public class SmsNotification implements INotification {
    @Override
    public void sendNotification(String message) {
        System.out.println(STR."Отправка SMS уведомления: \{message}");
    }
}
