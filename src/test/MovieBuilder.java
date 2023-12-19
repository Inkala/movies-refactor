package test;

import main.Movie;
import main.MovieType;

class MovieBuilder {

	private String title;
	private MovieType movieType;

	MovieBuilder() {
		title = "movieName";
	}

	MovieBuilder title(String title) {
		this.title = title;
		return this;
	}

	MovieBuilder movieType(MovieType movieType) {
		this.movieType = movieType;
		return this;
	}

	Movie build() {
		return new Movie(title, movieType);
	}

}
