package test;

import main.Customer;
import main.Movie;
import main.MovieType;
import main.Rental;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

	@Test
	public void withoutRentalsTest() {
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).totalAmount(0).frequentRenterPoints(0).build();
		assertEquals(result, statement);
	}

	@Test
	public void regularRental1DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).movieType(MovieType.REGULAR).build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2).totalAmount(2)
				.frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}

	@Test
	public void regularRental2DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).movieType(MovieType.REGULAR).build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2).totalAmount(2)
				.frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}

	@Test
	public void regularRental3DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).movieType(MovieType.REGULAR).build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3.5).totalAmount(3.5)
				.frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}

	@Test
	public void newReleaseRental1DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).movieType(MovieType.NEW_RELEASE).build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3).totalAmount(3)
				.frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}

	@Test
	public void newReleaseRental2DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).movieType(MovieType.NEW_RELEASE).build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3).totalAmount(3)
				.frequentRenterPoints(2).build();
		assertEquals(result, statement);
	}

	@Test
	public void newReleaseRental3DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).movieType(MovieType.NEW_RELEASE).build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3).totalAmount(3)
				.frequentRenterPoints(2).build();
		assertEquals(result, statement);
	}

	@Test
	public void childrenRental1DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).movieType(MovieType.CHILDREN).build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5).totalAmount(1.5)
				.frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}

	@Test
	public void childrenRental3DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).movieType(MovieType.CHILDREN).build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5).totalAmount(1.5)
				.frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}

	@Test
	public void childrenRental4DayTest() {
		String movieName = "movieName";
		Movie movie = new MovieBuilder().title(movieName).movieType(MovieType.CHILDREN).build();
		Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 6).totalAmount(6)
				.frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}

	@Test
	public void rentalTest() {
		String regularMovieName = "regularMovieName";
		Movie regularMovie = new MovieBuilder().title(regularMovieName).movieType(MovieType.REGULAR).build();
		Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();

		String newReleaseMovieName = "newReleaseMovieName";
		Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).movieType(MovieType.NEW_RELEASE).build();
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();

		String childrenMovieName = "childrenMovieName";
		Movie childrenMovie = new MovieBuilder().title(childrenMovieName).movieType(MovieType.CHILDREN).build();
		Rental childrenRental = new RentalBuilder().movie(childrenMovie).daysRented(10).build();

		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(regularRental).rental(newReleaseRental)
				.rental(childrenRental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(regularMovieName, 14)
				.movie(newReleaseMovieName, 3).movie(childrenMovieName, 15).totalAmount(32).frequentRenterPoints(4).build();
		assertEquals(result, statement);
	}

}
