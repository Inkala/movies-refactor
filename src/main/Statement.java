package main;

public class Statement {

    private final StringBuilder message = new StringBuilder();

    public Statement(String customerName) {
        message
                .append("\"Rental Record for \"")
                .append(customerName)
                .append("\n");
    }

    public void addRental(Rental rental) {
        double price = rental.getMovieAmount();
        message
                .append("\t")
                .append(rental.getMovie().getTitle())
                .append("\t")
                .append(price)
                .append("\n");
    }

    public String getMessage() {
        return message.toString();
    }
}
