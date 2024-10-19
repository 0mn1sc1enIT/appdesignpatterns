public class EmailNotification implements INotification {
    @Override
    public void sendNotification(String message) {
        System.out.println(STR."Отправка уведомления по электронной почте: \{message}");
    }
}
