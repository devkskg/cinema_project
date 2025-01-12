package cinema_project.model.vo;

public class ViewTimeTable {
	private int mNo;
	private int mRuntime;
	private String mTitle;
	private String tName;
	
	public ViewTimeTable() {
		
	}


	public ViewTimeTable(int mNo, int mRuntime, String mTitle, String tName) {
		this.mNo = mNo;
		this.mRuntime = mRuntime;
		this.mTitle = mTitle;
		this.tName = tName;
	}


	public int getmNo() {
		return mNo;
	}


	public void setmNo(int mNo) {
		this.mNo = mNo;
	}


	public int getmRuntime() {
		return mRuntime;
	}


	public void setmRuntime(int mRuntime) {
		this.mRuntime = mRuntime;
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
		return "[영화 번호=" + mNo + ", 러닝타임=" + mRuntime + ", 영화제목=" + mTitle + ", 상영관=" + tName + "]";
	}
	
	
	

}
