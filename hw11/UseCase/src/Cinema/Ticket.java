package Cinema;

public class Ticket {
    private Session session;
    private String buyer;

    public Ticket(Session session, String buyer) {
        this.session = session;
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return STR."Билет на \{session.GetMovie().GetTitle()}\tСеанс: \{session.GetDateTime()}\tПокупатель: \{buyer}";
    }
}
