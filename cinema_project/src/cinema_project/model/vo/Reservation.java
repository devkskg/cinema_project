package cinema_project.model.vo;

import java.time.LocalDateTime;

public class Reservation {
	private int rNo;
	private int uNo;
	private String mTitle;
	private String tName;
	private int rSeat;
	private LocalDateTime rDate;
	private int timeNo;
	
	public Reservation() {
		super();
	}
	
	
	
	
	public Reservation(int rNo, int uNo, String mTitle, String tName, int rSeat, LocalDateTime rDate, int timeNo) {
		super();
		this.rNo = rNo;
		this.uNo = uNo;
		this.mTitle = mTitle;
		this.tName = tName;
		this.rSeat = rSeat;
		this.rDate = rDate;
		this.timeNo = timeNo;
	}
	public int getrSeat() {
		return rSeat;
	}
	public void setrSeat(int rSeat) {
		this.rSeat = rSeat;
	}
	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	
	public LocalDateTime getrDate() {
		return rDate;
	}
	public void setrDate(LocalDateTime rDate) {
		this.rDate = rDate;
	}
	
	public int getTimeNo() {
		return timeNo;
	}




	public void setTimeNo(int timeNo) {
		this.timeNo = timeNo;
	}




	@Override
	public String toString() {
		return "영화제목 : " + mTitle + ", 상영관이름 : " + tName + ", 예매 좌석수 : " + rSeat;
	}
	
	
	
}
