package cinema_project.model.vo;

public class MovieVo {
    private int movieNumber;
    private String movieName;
    private int movieRuntime;
    private int moviePrice;
    private int movieRating;

    // 기본 생성자
    public MovieVo() {}

    // 영화 정보 생성자
    public MovieVo(int movieNumber, String movieName, int movieRuntime, int moviePrice, int movieRating) {
        this.movieNumber = movieNumber;
        this.movieName = movieName;
        this.movieRuntime = movieRuntime;
        this.moviePrice = moviePrice;
        this.movieRating = movieRating;
    }
    
    public MovieVo(String movieName, int movieRuntime, int moviePrice, int movieRating) {
        this.movieName = movieName;
        this.movieRuntime = movieRuntime;
        this.moviePrice = moviePrice;
        this.movieRating = movieRating;
    }
    
    
    // Getter and Setter
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
        return "[영화 번호: " + movieNumber + ", 이름: " + movieName + ", 러닝타임: " + movieRuntime + "분, 가격: " + moviePrice + ", 상영등급: " + movieRating+"]";
    }
} 