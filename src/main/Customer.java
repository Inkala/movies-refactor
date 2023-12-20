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
        CustomerStatement statement = new CustomerStatement(this.getName());
        rentals.forEach(statement::addRental);
        return statement.getMessage();
    }

}
