import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mediator {

    public interface IMediator {
        void SendMessage(String message, Colleague sender, String chatGroupName);
        void SendPrivateMessage(String message, Colleague sender, Colleague receiver);
        void LogMessage(String chatGroupName, String message);
        ArrayList<String> GetChatHistory(String chatGroupName);
        boolean IsColleagueInChat(String chatGroupName, Colleague colleague);
    }

    public abstract class Colleague {
        protected IMediator mediator;
        protected String name;

        public Colleague(IMediator mediator, String name) {
            this.mediator = mediator;
            this.name = name;
        }

        public abstract void ReceiveMessage(String message);

        public String getName() {
            return name;
        }
    }

    public class ChatMediator implements IMediator {
        private Map<String, ArrayList<Colleague>> chatGroups;
        private Map<String, ArrayList<String>> messageLogs;

        public ChatMediator() {
            chatGroups = new HashMap<>();
            messageLogs = new HashMap<>();
        }

        public void RegisterColleague(String chatGroupName, Colleague colleague) {
            chatGroups.putIfAbsent(chatGroupName, new ArrayList<>());
            chatGroups.get(chatGroupName).add(colleague);
        }

        public void DeleteColleague(String chatGroupName, Colleague colleague) {
            ArrayList<Colleague> colleagues = chatGroups.get(chatGroupName);
            if (colleagues != null) {
                colleagues.remove(colleague);
            }
        }

        public boolean IsColleagueInChat(String chatGroupName, Colleague colleague) {
            ArrayList<Colleague> colleagues = chatGroups.get(chatGroupName);
            return colleagues != null && colleagues.contains(colleague);
        }

        public void SendMessage(String message, Colleague sender, String chatGroupName) {
            if (!IsColleagueInChat(chatGroupName, sender)) {
                System.out.println(STR."\{sender.getName()} не зарегистрирован в группе \{chatGroupName} и не может отправить сообщение.");
                return;
            }

            ArrayList<Colleague> colleagues = chatGroups.get(chatGroupName);
            if (colleagues != null) {
                for (Colleague colleague : colleagues) {
                    if (colleague != sender) {
                        colleague.ReceiveMessage(STR."\{sender.getName()}: \{message}");
                    }
                }
                LogMessage(chatGroupName, STR."\{sender.getName()}: \{message}");
            }
        }

        public void SendPrivateMessage(String message, Colleague sender, Colleague receiver) {
            if (!IsColleagueInChatForPrivate(sender, receiver)) {
                System.out.println("Приватное сообщение не может быть отправлено. Один из участников не зарегистрирован.");
                return;
            }
            receiver.ReceiveMessage(STR."[Приват] \{sender.getName()}: \{message}");
        }

        private boolean IsColleagueInChatForPrivate(Colleague sender, Colleague receiver) {
            for (String chatGroupName : chatGroups.keySet()) {
                ArrayList<Colleague> colleagues = chatGroups.get(chatGroupName);
                if (colleagues != null && colleagues.contains(sender) && colleagues.contains(receiver)) {
                    return true;
                }
            }
            return false;
        }

        public void LogMessage(String chatGroupName, String message) {
            messageLogs.putIfAbsent(chatGroupName, new ArrayList<>());
            messageLogs.get(chatGroupName).add(message);
        }

        public ArrayList<String> GetChatHistory(String chatGroupName) {
            return messageLogs.getOrDefault(chatGroupName, new ArrayList<>());
        }
    }

    public class User extends Colleague {

        public User(IMediator mediator, String name) {
            super(mediator, name);
        }

        public void Send(String message, String chatGroupName) {
            System.out.println(STR."\{name} пытается отправить сообщение в группу \{chatGroupName}: \{message}");
            mediator.SendMessage(message, this, chatGroupName);
        }

        // Отправка приватного сообщения
        public void SendPrivate(String message, Colleague receiver) {
            System.out.println(STR."\{name} пытается отправить приватное сообщение \{receiver.getName()}: \{message}");
            mediator.SendPrivateMessage(message, this, receiver);
        }

        @Override
        public void ReceiveMessage(String message) {
            System.out.println(name + " получил сообщение: " + message);
        }
    }

    public void main(String[] args) {
        ChatMediator chatMediator = new ChatMediator();

        User user1 = new User(chatMediator, "Алиса");
        User user2 = new User(chatMediator, "Боб");
        User user3 = new User(chatMediator, "Чарли");

        chatMediator.RegisterColleague("Group1", user1);
        chatMediator.RegisterColleague("Group1", user2);
        chatMediator.RegisterColleague("Group2", user2);
        chatMediator.RegisterColleague("Group2", user3);

        user1.Send("Привет всем из Group1!", "Group1");
        user2.Send("Привет, Алиса!", "Group1");
        user3.Send("Привет из Group2!", "Group2");

        user1.SendPrivate("Как дела, Боб?", user2);
        user3.Send("Привет, Алиса!", "Group1");

        // История сообщений
        System.out.println(STR."История сообщений Group1: \{chatMediator.GetChatHistory("Group1")}");
        System.out.println(STR."История сообщений Group2: \{chatMediator.GetChatHistory("Group2")}");
    }
}
