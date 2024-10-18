public class Main {
    public void main(String[] args)
    {
        ChatRoom chatRoom = new ChatRoom();

        User user1 = new User("Алиса", chatRoom);
        User user2 = new User("Боб", chatRoom);
        User user3 = new User("Чарли", chatRoom);

        user1.Join();
        user2.Join();
        user3.Join();

        user1.Send("Привет, всем!");
        user2.Send("Привет, Алиса!");
        user3.Send("Привет, Боб!");

        user2.Leave();
        user1.Send("Пока!");
    }
}
