package cinema_project.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movie {
	private int mNo;
	private String mTitle;
	private int mRuntime;
	private int mPrice;
	private int mRating;
	private int mCount;
	private String mReview;
	
	public Movie() {}

	public Movie(int mNo, String mTitle, int mRuntime, int mPrice, int mRating, int mCount, String mReview) {
		super();
		this.mNo = mNo;
		this.mTitle = mTitle;
		this.mRuntime = mRuntime;
		this.mPrice = mPrice;
		this.mRating = mRating;
		this.mCount = mCount;
		this.mReview = mReview;
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

	public int getmCount() {
		return mCount;
	}

	public void setmCount(int mCount) {
		this.mCount = mCount;
	}

	public String getmReview() {
		return mReview;
	}

	public void setmReview(String mReview) {
		this.mReview = mReview;
	}

	@Override
	public String toString() {
		return "[영화번호=" + mNo 
				+ ", 영화제목=" + mTitle
				+ ", 러닝타임=" + mRuntime 
				+ ", 가격=" + mPrice
				+ ", 연령제한=" + mRating 
				+ ", 관객수=" + mCount 
				+ ", 리뷰=" + mReview + "]";
	}
	
	
	
	

	
	
	
	
	

}
