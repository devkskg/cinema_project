package cinema_project.model.vo;

public class Vo {
	
	private int movieNumber;
	private String movieName;
	private int movieRuntime;
	private int moviePrice;
	private int movieRating;
	private String theaterName;
	private int theaterSeat;
	private int theaterLineseat;
	private int theaterNumber;
	
	public void Vo() {}
	
	public Vo(int theaterNumber, String theaterName, int theaterSeat, int theaterLineseat) {
		this.theaterName = theaterName;
		this.theaterSeat = theaterSeat;
		this.theaterLineseat = theaterLineseat;
		this.theaterNumber = theaterNumber;
	}
	
	
		public Vo(String theaterName, int theaterSeat, int theaterLineseat) {
			this.theaterName = theaterName;
			this.theaterSeat = theaterSeat;
			this.theaterLineseat = theaterLineseat;
		}
	
	  public Vo(String movieName, int movieRuntime, int moviePrice, int movieRating) {
	        this.movieName = movieName;
	        this.movieRuntime = movieRuntime;
	        this.moviePrice = moviePrice;
	        this.movieRating = movieRating;
	}
	
	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public int getTheaterSeat() {
		return theaterSeat;
	}

	public void setTheaterSeat(int theaterSeat) {
		this.theaterSeat = theaterSeat;
	}

	public int getTheaterLineseat() {
		return theaterLineseat;
	}

	public void setTheaterLineseat(int theaterLineseat) {
		this.theaterLineseat = theaterLineseat;
	}

	public int getTheaterNumber() {
		return theaterNumber;
	}
	
	public void setTheaterNumber(int theaterNumber) {
		this.theaterNumber = theaterNumber;
	}
	
	public Vo(int movieNumber,String movieName,int movieRuntime,int moviePrice,int movieRating) {
		this.movieNumber = movieNumber;
		this.movieName = movieName;
		this.movieRuntime = movieRuntime; 
		this.moviePrice = moviePrice;
		this.movieRating = movieRating;
	}
		
	public int getMovieNumber() {
		return movieNumber;
	}

	public void setMovieNumber(int movieNumber) {
		this.movieNumber = movieNumber;
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

	@Override
	public String toString() {
		return "영화번호"+movieNumber+"이름:"+movieName+"러닝타임:"+movieRuntime+"가격"+moviePrice+"상영등급"+movieRating;
	}


} 
