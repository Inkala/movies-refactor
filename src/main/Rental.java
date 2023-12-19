package main;

public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getMovieAmount() {
        return this.getMovie().getPrice(daysRented);
    }

    public int getFrequentRenterPoints() {
        return this.getMovie().getFrequentRenterPoints(daysRented);
    }

}
