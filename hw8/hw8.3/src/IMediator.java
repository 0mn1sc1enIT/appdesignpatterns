public interface IMediator {
    void SendMessage(String message, User sender);
    void Join(User user);
    void Leave(User user);
}