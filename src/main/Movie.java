package main;

public class Movie {
    private final String title;
    private MovieType movieType;

    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public double getPrice(int daysRented) {
        return movieType.getPrice(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return movieType.getFrequentRenterPoints(daysRented);
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public String getTitle() {
        return title;
    }

}
