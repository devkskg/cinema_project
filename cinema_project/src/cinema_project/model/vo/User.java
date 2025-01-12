package cinema_project.model.vo;

public class User {
	private int userNo;
    private String userId;
    private String userPw;
    private String userName;
    private String userSsn;
    private String userPhone;
    private String userManager;

    // Constructors, Getters, Setters, and toString
    public User() {}

    public User(String userId, String userPw, String userName, String userSsn, String userPhone) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userSsn = userSsn;
        this.userPhone = userPhone;
        this.userManager = "N";
    }

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

    public String getUserManager() {
        return userManager;
    }

    public void setUserManager(String userManager) {
        this.userManager = userManager;
    }

    @Override
    public String toString() {
        return "[번호: " + userNo +
                ", 아이디: " + userId +
                ", 이름: " + userName +
                ", 주민등록번호: " + userSsn +
                ", 전화번호: " + userPhone +
                ", 관리자 여부: " + userManager + "]";
    }
}
