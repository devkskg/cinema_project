package cinema_project.vo;

public class Vo {
	
	private String movieName;
	private int movieRuntime;
	private int moviePrice;
	private int movieRating;

	public void vo() {
		
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieRuntime() {
		return movieRuntime;
	}

	public void setMovieRuntime(int movieRuntime) {
		this.movieRuntime = movieRuntime;
	}

	public int getMoviePrice() {
		return moviePrice;
	}

	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	public Vo(String movieName, int movieRuntime, int moviePrice, int movieRating) {
		super();
		this.movieName = movieName;
		this.movieRuntime = movieRuntime;
		this.moviePrice = moviePrice;
		this.movieRating = movieRating;
	}
	
}
