package Users;

import Cinema.CinemaSystem;
import Cinema.Movie;
import Cinema.Session;

public class Admin extends User {
    private CinemaSystem cinemaSystem;
    public Admin(String name, CinemaSystem cinemaSystem) {
        super(name);
        this.cinemaSystem = cinemaSystem;
    }

    public void AddMovie(String title, String genre, int duration) {
        Movie movie = new Movie(title, genre, duration);
        cinemaSystem.AddMovie(movie);
    }

    public void AddSession(Movie movie, String dateTime, int availableSeats) {
        Session session = new Session(movie, dateTime, availableSeats);
        cinemaSystem.AddSession(session);
    }
}
