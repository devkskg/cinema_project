package cinema_project.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timetableksk {
	private int timeNo;
	private String mTitle;
	private String tName;
	private int tSeat;
	private LocalDateTime timeStart;
	private LocalDateTime timeEnd;
	public Timetableksk() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Timetableksk(int timeNo, String mTitle, String tName, LocalDateTime timeStart, LocalDateTime timeEnd) {
		super();
		this.timeNo = timeNo;
		this.mTitle = mTitle;
		this.tName = tName;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}

	public Timetableksk(String mTitle, String tName, LocalDateTime timeStart, LocalDateTime timeEnd) {
		super();
		this.mTitle = mTitle;
		this.tName = tName;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	public Timetableksk(String mTitle, String tName, int tSeat, LocalDateTime timeStart, LocalDateTime timeEnd) {
		super();
		this.mTitle = mTitle;
		this.tName = tName;
		this.tSeat = tSeat;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	
	
	public Timetableksk(int timeNo, String mTitle, String tName, int tSeat, LocalDateTime timeStart,
			LocalDateTime timeEnd) {
		super();
		this.timeNo = timeNo;
		this.mTitle = mTitle;
		this.tName = tName;
		this.tSeat = tSeat;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
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
	public LocalDateTime getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(LocalDateTime timeStart) {
		this.timeStart = timeStart;
	}
	public LocalDateTime getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(LocalDateTime timeEnd) {
		this.timeEnd = timeEnd;
	}
	
	public int getTimeNo() {
		return timeNo;
	}

	public void setTimeNo(int timeNo) {
		this.timeNo = timeNo;
	}

	public int gettSeat() {
		return tSeat;
	}

	public void settSeat(int tSeat) {
		this.tSeat = tSeat;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-SS");
		return "영화제목 : " + mTitle 
				+ ", 상영관이름 : " + tName 
				+ ", 남은 좌석수 : " + tSeat
				+ ", 상영 시작시간 : " + timeStart.format(dtf) 
				+ ", 종료시간 : "+ timeEnd.format(dtf);
	}
	
	
}
