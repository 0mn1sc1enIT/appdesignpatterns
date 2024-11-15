package Cinema;

public class Movie {
    private String title;
    private String genre;
    private int duration;

    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public String GetTitle() {
        return title;
    }

    @Override
    public String toString() {
        return STR."Фильм: \{title}\tЖанр: \{genre}\tПродолжительность: \{duration} мин";
    }
}
