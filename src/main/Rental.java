package main;

public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getMovieAmount() {
        double amount = 0;

        switch (this.getMovie().getMovieType()) {
            case REGULAR:
                amount += this.getMovie().getMovieType().getBasePrice();
                if (this.getDaysRented() > 2) {
                    amount += (this.getDaysRented() - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                amount += this.getMovie().getMovieType().getBasePrice();
                break;
            case CHILDREN:
                amount += this.getMovie().getMovieType().getBasePrice();
                if (this.getDaysRented() > 3) {
                    amount += (this.getDaysRented() - 1) * 1.5;
                }
                break;
        }

        return amount;
    }

    public int getFrequentRenterPoints() {
        int rentalPoints = 1;
        if ((this.getMovie().getMovieType() == MovieType.NEW_RELEASE) && this.getDaysRented() > 1) {
            rentalPoints++;
        }
        return rentalPoints;
    }

}
