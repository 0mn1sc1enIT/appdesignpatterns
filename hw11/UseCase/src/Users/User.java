package Users;

import Cinema.Session;
import Cinema.Ticket;

public class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Ticket BuyTicket(Session session) {
        if (session.BookSeat()) {
            return new Ticket(session, name);
        } else {
            System.out.println("Мест нет на выбранный сеанс.");
            return null;
        }
    }
}
