package cinema_project.model.vo;

public class Theater {
	private int tNo;
	private String tName;
	private int tSeat;
	private int tLineseat;
	
	
	public Theater() {}


	public Theater(int tNo, String tName, int tSeat, int tLineseat) {
		super();
		this.tNo = tNo;
		this.tName = tName;
		this.tSeat = tSeat;
		this.tLineseat = tLineseat;
	}


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


	@Override
	public String toString() {
		return "[시간표 번호=" + tNo 
				+ ", 상영관 이름=" + tName 
				+ ", 총 좌석 수=" + tSeat 
				+ ", 한줄 좌석 수=" + tLineseat + "]";
	}
	
	
	
	
	
	

}
