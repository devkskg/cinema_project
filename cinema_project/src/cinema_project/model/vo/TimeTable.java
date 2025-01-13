package cinema_project.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTable {
	private int timeNo;
	private String mTitle;
	private String tName;
	private LocalDateTime timeStart;
	private LocalDateTime timeEnd;
	
	
	
	public TimeTable() {}
	

	
	public TimeTable(String mTitle , String tName , LocalDateTime timeStart , LocalDateTime timeEnd) {
		this.mTitle = mTitle;
		this.tName = tName;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}

	public TimeTable(int timeNo, String mTitle, String tName, LocalDateTime timeStart, LocalDateTime timeEnd) {
		this.timeNo = timeNo;
		this.mTitle = mTitle;
		this.tName = tName;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
	

	public int getTimeNo() {
		return timeNo;
	}

	public void setTimeNo(int timeNo) {
		this.timeNo = timeNo;
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

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
		return "[timeNo=" + timeNo  
				+ ", mTitle=" + mTitle 
				+ ", tName=" + tName
				+ ", timeStart=" + timeStart.format(dtf)
				+ ", timeEnd=" + timeEnd.format(dtf) + "]";
	}
	
	
	
	

}
