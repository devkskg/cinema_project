package cinema_project.model.vo;

public class User {
	private int uNo;
    private String uId;
    private String uPw;
    private String uName;
    private String uSsn;
    private String uPhone;
    private String uManager;

    public User(int uNo, String uId, String uPw, String uName, String uSsn, String uPhone, String uManager) {
        this.uNo = uNo;
        this.uId = uId;
        this.uPw = uPw;
        this.uName = uName;
        this.uSsn = uSsn;
        this.uPhone = uPhone;
        this.uManager = uManager;
    }

    public int getuNo() {
        return uNo;
    }

    public String getuId() {
        return uId;
    }

    public String getuPw() {
        return uPw;
    }

    public String getuName() {
        return uName;
    }

    public String getuSsn() {
        return uSsn;
    }

    public String getuPhone() {
        return uPhone;
    }

    public String getuManager() {
        return uManager;
    }

    @Override
    public String toString() {
        return 
               "번호 : " + uNo +
               ", 아이디 : " + uId + '\'' +
               ", 비밀번호 : " + uPw + '\'' +
               ", 이름 : " + uName + '\'' +
               ", 주민등록번호 : " + uSsn + '\'' +
               ", 전화번호 : " + uPhone + '\'' +
               ", 관리자 : " + uManager;
    }
}
