package cinema_project.model.vo;

public class TheaterVo {
    private int theaterNumber;
    private String theaterName;
    private int theaterSeat;
    private int theaterLineseat;

    // 기본 생성자
    public TheaterVo() {}

    // 상영관 정보 생성자
    public TheaterVo(int theaterNumber, String theaterName, int theaterSeat, int theaterLineseat) {
        this.theaterNumber = theaterNumber;
        this.theaterName = theaterName;
        this.theaterSeat = theaterSeat;
        this.theaterLineseat = theaterLineseat;
    }
    
    public TheaterVo(String theaterName, int theaterSeat, int theaterLineseat) {
        this.theaterName = theaterName;
        this.theaterSeat = theaterSeat;
        this.theaterLineseat = theaterLineseat;
    }
    // Getter and Setter
    public int getTheaterNumber() {
        return theaterNumber;
    }

    public void setTheaterNumber(int theaterNumber) {
        this.theaterNumber = theaterNumber;
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

    @Override
    public String toString() {
        return "[상영관 번호: " + theaterNumber + ", 이름: " + theaterName + ", 좌석 수: " + theaterSeat + ", 한 줄 좌석: " + theaterLineseat+"]";
    }
} 