package Cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemaSystem {
    private List<Movie> movies = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();

    public void AddMovie(Movie movie) {
        movies.add(movie);
    }

    public void AddSession(Session session) {
        sessions.add(session);
    }

    public Movie GetMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.GetTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    public Session GetSessionByMovieTitleAndDateTime(String movieTitle, String dateTime) {
        for (Session session : sessions) {
            if (session.GetMovie().GetTitle().equalsIgnoreCase(movieTitle) && session.GetDateTime().equals(dateTime)) {
                return session;
            }
        }
        return null;
    }

    public void ShowMovies() {
        System.out.println("Список доступных фильмов:");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void ShowSessions() {
        System.out.println("Список доступных сеансов:");
        for (Session session : sessions) {
            System.out.println(session);
        }
    }
}
