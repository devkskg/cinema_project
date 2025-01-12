package cinema_project.model.vo;



public class TimeTable {
	private int timeNo;
	private String mTitle;
	private String tName;
	private String timeStart;
	private String timeEnd;
	
	public TimeTable() {}
	
	public TimeTable(String mTitle , String tName , String timeStart , String timeEnd) {
		this.mTitle = mTitle;
		this.tName = tName;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}

	public TimeTable(int timeNo, String mTitle, String tName, String timeStart, String timeEnd) {
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

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Override
	public String toString() {
		return "[timeNo=" + timeNo  
				+ ", mTitle=" + mTitle 
				+ ", tName=" + tName
				+ ", timeStart=" + timeStart
				+ ", timeEnd=" + timeEnd + "]";
	}
	
	
	
	

}
