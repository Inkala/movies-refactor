package main;

public class Statement {

    private final StringBuilder message = new StringBuilder();
    private double totalPrice = 0;
    private int totalFrequentRenterPoints = 0;

    public Statement(String customerName) {
        message
                .append("\"Rental Record for \"")
                .append(customerName)
                .append("\n");
    }

    public void addRental(Rental rental) {
        double price = rental.getPrice();
        totalPrice += price;
        totalFrequentRenterPoints = rental.getFrequentRenterPoints();
        message
                .append("\t")
                .append(rental.getTitle())
                .append("\t")
                .append(price)
                .append("\n");
    }

    public String getMessage() {
        return message
                .append("Amount owed is ")
                .append(totalPrice)
                .append("\n")
                .append("Amount owed is ")
                .append(totalFrequentRenterPoints)
                .append(" frequent renter points")
                .toString();
    }
}
