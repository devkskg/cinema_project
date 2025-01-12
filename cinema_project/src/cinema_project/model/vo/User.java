package cinema_project.model.vo;

public class User {
	 private int userNo;
	    private String userId;
	    private String userPw;
	    private String userName;
	    private String userSsn;
	    private String userPhone;
	    private String isAdmin;

	    // Getters and Setters
	    public int getUserNo() {
	        return userNo;
	    }

	    public void setUserNo(int userNo) {
	        this.userNo = userNo;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId;
	    }

	    public String getUserPw() {
	        return userPw;
	    }

	    public void setUserPw(String userPw) {
	        this.userPw = userPw;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getUserSsn() {
	        return userSsn;
	    }

	    public void setUserSsn(String userSsn) {
	        this.userSsn = userSsn;
	    }

	    public String getUserPhone() {
	        return userPhone;
	    }

	    public void setUserPhone(String userPhone) {
	        this.userPhone = userPhone;
	    }

	    public String getIsAdmin() {
	        return isAdmin;
	    }

	    public void setIsAdmin(String isAdmin) {
	        this.isAdmin = isAdmin;
	    }
	}
//		@Override
//		public String toString() {
//			return " [유저번호 : " + userNo + ", 아이디 : " + userId + ", 비밀번호 : " + userPw + ", 이름 : " + userName
//					+ ", 주민등록번호 : " + userSsn + ", 전화번호 : " + userPhone + ", 관리자 : " + isManager + "]";
//		}


