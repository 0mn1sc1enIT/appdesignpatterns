package Cinema;

public class Session {
    private Movie movie;
    private String dateTime;
    private int availableSeats;

    public Session(Movie movie, String dateTime, int availableSeats) {
        this.movie = movie;
        this.dateTime = dateTime;
        this.availableSeats = availableSeats;
    }

    public Movie GetMovie() {
        return movie;
    }

    public String GetDateTime() {
        return dateTime;
    }

    public boolean hasAvailableSeats() {
        return availableSeats > 0;
    }

    public boolean BookSeat() {
        if (hasAvailableSeats()) {
            availableSeats--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return STR."\{movie}\tДата и время: \{dateTime}\tДоступные места: \{availableSeats}";
    }
}
