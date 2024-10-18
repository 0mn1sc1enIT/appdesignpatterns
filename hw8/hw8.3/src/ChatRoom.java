import java.util.ArrayList;

public class ChatRoom implements IMediator {
    private ArrayList<User> users = new ArrayList<User>();
    public void SendMessage(String message, User sender) {
        for (var user: users) {
            if (user != sender) {
                user.Receive(message);
            }
        }
    }

    public void Join(User user) {
        users.add(user);
        System.out.println(STR."\{user.name} присоединился к чату");
        SendMessage(STR."\{user.name} присоединился к чату", user);
    }

    public void Leave(User user) {
        users.remove(user);
        System.out.println(STR."\{user.name} покинул чат");
        SendMessage(STR."\{user.name} покинул чат", user);
    }
}