package cinema_project.model.vo;

import java.time.LocalDateTime;

public class Reservationksk {
	private int rNo;
	private int uNo;
	private String mTitle;
	private String tName;
	private int rSeat;
	private LocalDateTime rDate;
	
	public Reservationksk() {
		super();
	}
	public Reservationksk(int rNo, int uNo, String mTitle, String tName, int rSeat) {
		super();
		this.rNo = rNo;
		this.uNo = uNo;
		this.mTitle = mTitle;
		this.tName = tName;
		this.rSeat = rSeat;
	}
	public Reservationksk(String mTitle, String tName, int rSeat) {
		super();
		this.mTitle = mTitle;
		this.tName = tName;
		this.rSeat = rSeat;
	}
	
	
	
	
	public Reservationksk(int rNo, int uNo, String mTitle, String tName, int rSeat, LocalDateTime rDate) {
		super();
		this.rNo = rNo;
		this.uNo = uNo;
		this.mTitle = mTitle;
		this.tName = tName;
		this.rSeat = rSeat;
		this.rDate = rDate;
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
	@Override
	public String toString() {
		return "영화제목 : " + mTitle + ", 상영관이름 : " + tName + ", 예매 좌석수 : " + rSeat;
	}
	
	
	
}
