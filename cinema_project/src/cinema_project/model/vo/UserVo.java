package cinema_project.model.vo;

public class UserVo {
	 private int uNo;
	    private String uId;
	    private String uPw;
	    private String uName;
	    private String uSsn;
	    private String uPhone;
	    private String uManager;

	    
	    public UserVo(int uNo, String uId, String uPw, String uName, String uSsn, String uPhone,
				String uManager) {
			super();
			this.uNo = uNo;
			this.uId = uId;
			this.uPw = uPw;
			this.uName = uName;
			this.uSsn = uSsn;
			this.uPhone = uPhone;
			this.uManager = uManager;
		}
	    public UserVo(String uManager) {
	    	this.uManager = uManager;
	    }

		public String getuManager() {
			return uManager;
		}
		public void setuManager(String uManager) {
			this.uManager = uManager;
		}
		public UserVo() {
			
		}

		public UserVo(String uName, String uSsn, String uPhone) {
			super();
			this.uName = uName;
			this.uSsn = uSsn;
			this.uPhone = uPhone;
		}

//		public int getUserNo() {
//	        return uNo;
//	    }
//
//	    public void setUserNo(int uNo) {
//	        this.uNo = uNo;
//	    }

	    public String getUserId() {
	        return uId;
	    }

	    public void setUserId(String uId) {
	        this.uId = uId;
	    }

	    public String getUserPw() {
	        return uPw;
	    }

	    public void setUserPw(String uPw) {
	        this.uPw = uPw;
	    }

	    public String getUserName() {
	        return uName;
	    }

	    public void setUserName(String uName) {
	        this.uName = uName;
	    }

	    public String getUserSsn() {
	        return uSsn;
	    }

	    public void setUserSsn(String uSsn) {
	        this.uSsn = uSsn;
	    }

	    public String getUserPhone() {
	        return uPhone;
	    }

	    public void setUserPhone(String uPhone) {
	        this.uPhone = uPhone;
	    }

	    public String getUserManager() {
	        return uManager;
	    }

	    public void setUserManager(String uManager) {
	        this.uManager = uManager;
	    }
		@Override
		public String toString() {
			return "아이디:" + uId + ", 비밀번호:" + uPw + ", 이름:" + uName
					+ ", 주민번호:" + uSsn + ", 전화번호:" + uPhone;
		}
	}

