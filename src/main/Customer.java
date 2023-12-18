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
        String result = "Rental Record for " + this.getName() + "\n";
        while (rentals.hasNext()) {
            Rental rental = rentals.next();
            double amount = getMovieAmount(rental);

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(amount) + "\n";
            totalAmount += amount;
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double getMovieAmount(Rental rental) {
        double amount = 0;

        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (rental.getDaysRented() > 2) {
                    amount += (rental.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                amount += 3;
                break;
            case Movie.CHILDREN:
                amount += 1.5;
                if (rental.getDaysRented() > 3) {
                    amount += (rental.getDaysRented() - 1) * 1.5;
                }
                break;
        }
        return amount;
    }

}
