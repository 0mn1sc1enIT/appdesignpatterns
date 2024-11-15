import Cinema.*;
import Users.*;

public class Main {
    public static void main(String[] args) {
        CinemaSystem cinemaSystem = new CinemaSystem();
        Admin admin = new Admin("Амиржан", cinemaSystem);
        User user = new User("Нурбол");

        admin.AddMovie("Интерстеллар", "Научная фантастика", 169);
        admin.AddMovie("Начало", "Фантастика", 148);

        Movie movie1 = cinemaSystem.GetMovieByTitle("Интерстеллар");
        Movie movie2 = cinemaSystem.GetMovieByTitle("Начало");
        if (movie1 != null) {
            admin.AddSession(movie1, "2024-12-01 18:00", 50);
        }
        if (movie2 != null) {
            admin.AddSession(movie2, "2024-12-01 20:00", 30);
        }

        cinemaSystem.ShowMovies();
        cinemaSystem.ShowSessions();

        Session session = cinemaSystem.GetSessionByMovieTitleAndDateTime("Интерстеллар", "2024-12-01 18:00");
        if (session != null) {
            Ticket ticket = user.BuyTicket(session);
            if (ticket != null) {
                System.out.println(STR."Билет успешно куплен: \{ticket}");
            }
        }
    }
}
