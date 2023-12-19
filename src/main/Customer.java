package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new ArrayList<Rental>();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = this.rentals.iterator();
        Statement statement = new Statement(this.getName());

        while (rentals.hasNext()) {
            Rental rental = rentals.next();
            frequentRenterPoints += rental.getFrequentRenterPoints();

            statement.addRental(rental);
            totalAmount += rental.getPrice();
        }
        // add footer lines
        String message = statement.getMessage();
        message += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        message += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return message;
    }

}
