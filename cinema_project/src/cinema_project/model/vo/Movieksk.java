package cinema_project.model.vo;

public class Movieksk {
	private int mNo;
	private String mTitle;
	private int mRuntime;
	private int mPrice;
	private int mRating;
	public Movieksk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movieksk(int mNo, String mTitle, int mRuntime, int mPrice, int mRating) {
		super();
		this.mNo = mNo;
		this.mTitle = mTitle;
		this.mRuntime = mRuntime;
		this.mPrice = mPrice;
		this.mRating = mRating;
	}
	public Movieksk(String mTitle, int mRuntime, int mPrice, int mRating) {
		super();
		this.mTitle = mTitle;
		this.mRuntime = mRuntime;
		this.mPrice = mPrice;
		this.mRating = mRating;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public int getmRuntime() {
		return mRuntime;
	}
	public void setmRuntime(int mRuntime) {
		this.mRuntime = mRuntime;
	}
	public int getmPrice() {
		return mPrice;
	}
	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}
	public int getmRating() {
		return mRating;
	}
	public void setmRating(int mRating) {
		this.mRating = mRating;
	}
	@Override
	public String toString() {
		return "영화제목 : " + mTitle + ", 러닝타임 : " + mRuntime + ", 티켓가격 : " + mPrice
				+ ", 나이제한 : " + mRating;
	}
	
	
}
