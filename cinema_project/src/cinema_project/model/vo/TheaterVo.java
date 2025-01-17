package cinema_project.model.vo;

public class TheaterVo {
    private int tNo;
    private String tName;
    private int tSeat;
    private int tLineseat;

    public TheaterVo() {}

    public int gettNo() {
		return tNo;
	}



	public void settNo(int tNo) {
		this.tNo = tNo;
	}



	public String gettName() {
		return tName;
	}



	public void settName(String tName) {
		this.tName = tName;
	}



	public int gettSeat() {
		return tSeat;
	}



	public void settSeat(int tSeat) {
		this.tSeat = tSeat;
	}



	public int gettLineseat() {
		return tLineseat;
	}



	public void settLineseat(int tLineseat) {
		this.tLineseat = tLineseat;
	}



	public TheaterVo(int tNo, String tName, int tSeat, int tLineseat) {
		super();
		this.tNo = tNo;
		this.tName = tName;
		this.tSeat = tSeat;
		this.tLineseat = tLineseat;
	}
	
	public TheaterVo(String tName, int tSeat, int tLineseat) {
		super();
		this.tName = tName;
		this.tSeat = tSeat;
		this.tLineseat = tLineseat;
	}
	



	@Override
    public String toString() {
        return "[상영관 번호: " + tNo + ", 이름: " + tName + ", 좌석 수: " + tSeat + ", 한 줄 좌석: " + tLineseat+"]";
    }
} 