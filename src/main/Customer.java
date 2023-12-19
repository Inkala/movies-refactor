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
        Iterator<Rental> rentals = this.rentals.iterator();
        Statement statement = new Statement(this.getName());

        while (rentals.hasNext()) {
            Rental rental = rentals.next();
            statement.addRental(rental);
        }

        return statement.getMessage();
    }

}
