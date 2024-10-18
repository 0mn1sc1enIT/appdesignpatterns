public class User {
    String name;
    private IMediator mediator;

    public User(String name, IMediator mediator)
    {
        this.name = name;
        this.mediator = mediator;
    }

    public void Send(String message)
    {
        System.out.println(STR."\{name} отправляет: \{message}");
        mediator.SendMessage(message, this);
    }

    public void Receive(String message)
    {
        System.out.println(STR."\{name} получил: \{message}");
    }

    public void Join()
    {
        mediator.Join(this);
    }

    public void Leave()
    {
        mediator.Leave(this);
    }
}