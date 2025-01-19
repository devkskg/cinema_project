package cinema_project.model.vo;

public class MovieVo {
	private int mNo;
	private String mTitle;
	private int mRuntime;
	private int mPrice;
	private int mRating;
	private int mCount;
	private String mReview;

    // 기본 생성자
    public MovieVo() {}

   

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



	public MovieVo(int mNo, String mTitle, int mRuntime, int mPrice, int mRating, int mCount, String mReview) {
		super();
		this.mNo = mNo;
		this.mTitle = mTitle;
		this.mRuntime = mRuntime;
		this.mPrice = mPrice;
		this.mRating = mRating;
		this.mCount = mCount;
		this.mReview = mReview;
	}
	
	public MovieVo(String mTitle, int mRuntime, int mPrice, int mRating) {
		super();
		this.mTitle = mTitle;
		this.mRuntime = mRuntime;
		this.mPrice = mPrice;
		this.mRating = mRating;
	}

	public MovieVo(int mNo, String mTitle, int mRuntime, int mPrice, int mRating) {
		super();
		this.mNo =  mNo;
		this.mTitle = mTitle;
		this.mRuntime = mRuntime;
		this.mPrice = mPrice;
		this.mRating = mRating;
	}



	@Override
    public String toString() {
        return "[영화 번호: " + mNo + ", 이름: " + mTitle + ", 러닝타임: " + mRuntime + "분, 가격: " + mPrice + ", 상영등급: " + mRating+"]";
    }
    
} 