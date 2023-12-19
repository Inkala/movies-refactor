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
        return this.getMovie().getMovieType().getPrice(this.daysRented);
    }

    public int getFrequentRenterPoints() {
        int rentalPoints = 1;
        if ((this.getMovie().getMovieType() == MovieType.NEW_RELEASE) && this.daysRented > 1) {
            rentalPoints++;
        }
        return rentalPoints;
    }

}
