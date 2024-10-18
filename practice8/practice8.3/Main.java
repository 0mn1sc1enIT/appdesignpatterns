import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public interface IMediator {
        void SendMessage(String message,IUser sender);
        void AddUser(IUser user);
        void RemoveUser(IUser user);
    }

    public class ChatMediator implements IMediator {
        private List<IUser> users;
        public ChatMediator() {
            users = new ArrayList<IUser>();
        }
        @Override
        public void SendMessage(String message, IUser sender) {
            for (var user: users) {
                if (user != sender) {
                    user.ReceiveMessage(message, sender);
                }
            }
        }
        @Override
        public void AddUser(IUser user) {
            users.add(user);
        }
        @Override
        public void RemoveUser(IUser user) {
            users.remove(user);
        }
    }

    public interface IUser {
        void SendMessage(String message);
        void ReceiveMessage(String message, IUser sender);
        void ReceiveSystemMessage(String message);
        String GetName();
    }
    public class User implements IUser {
        private String name;
        private IMediator mediator;
        public User(String name, IMediator mediator) {
            this.name= name;
            this.mediator = mediator;
        }
        @Override
        public void SendMessage(String message) {
            System.out.println(STR."\{name} send message: \{message}");
            mediator.SendMessage(message, this);
        }
        @Override
        public void ReceiveMessage(String message, IUser sender) {
            System.out.println(STR."\{name} receive message from \{sender.GetName()}: \{message}");
        }
        @Override
        public void ReceiveSystemMessage(String message) {
            System.out.println(STR."[System message for \{name}]: \{message}");
        }
        @Override
        public String GetName() {
            return name;
        }
    }

    public class ChannelMediator implements IMediator {
        private String channelName;
        private Map<String, List<IUser>> channels;

        public ChannelMediator(String channelName) {
            this.channelName = channelName;
            channels = new HashMap<>();
        }

        @Override
        public void SendMessage(String message, IUser sender) {
            if (channels.containsKey(channelName)) {
                for (var user: channels.get(channelName)) {
                    if (user != sender) {
                        user.ReceiveMessage(message, sender);
                    }
                }
            }
        }

        @Override
        public void AddUser(IUser user) {
            if (!channels.containsKey(channelName)) {
                channels.put(channelName, new ArrayList<>());
            }
            channels.get(channelName).add(user);
        }

        @Override
        public void RemoveUser(IUser user) {
            if (channels.containsKey(channelName)) {
                channels.remove(user);
            }
        }
    }

    public void main(String[] args) {
        ChannelMediator mediator = new ChannelMediator("devOpsChat");

        IUser user1 = new User("Zuk", mediator);
        IUser user2 = new User("Ben", mediator);
        IUser user3 = new User("Ali", mediator);

        mediator.AddUser(user1);
        mediator.AddUser(user2);
        mediator.AddUser(user3);

        System.out.println("Zuk send message in channel devOpsChats");
        user1.SendMessage("Hello everyone from Zuk");

        System.out.println("Ben send message in channel devOpsChats");
        user2.SendMessage("Hello everyone from Ben");

        System.out.println("Ali send message in channel devOpsChats");
        user1.SendMessage("Hello everyone from Ali");
    }
}
