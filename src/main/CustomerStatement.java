package main;

public class CustomerStatement {
    private final StringBuilder message = new StringBuilder();
    private double totalPrice = 0;
    private int totalFrequentRenterPoints = 0;

    public CustomerStatement(String customerName) {
        message
                .append(String.format("Rental Record for %s", customerName))
                .append("\n");
    }

    public void addRental(Rental rental) {
        double price = rental.getPrice();
        totalPrice += price;
        totalFrequentRenterPoints += rental.getFrequentRenterPoints();
        message
                .append(String.format("\t%s\t%s", rental.getTitle(), String.valueOf(price)))
                .append("\n");
    }

    public String build() {
        return message
                .append(String.format("Amount owed is %s", String.valueOf(totalPrice)))
                .append("\n")
                .append(String.format("You earned %d frequent renter points", totalFrequentRenterPoints))
                .toString();
    }
}