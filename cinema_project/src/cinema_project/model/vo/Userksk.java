package cinema_project.model.vo;

public class Userksk {
	private int uNo;
	private String uId;
	private String uPw;
	private String uName;
	private String uSsn;
	private String uPhone;
	private String uManager;
	public Userksk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Userksk(int uNo, String uId, String uPw, String uName, String uSsn, String uPhone, String uManager) {
		super();
		this.uNo = uNo;
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uSsn = uSsn;
		this.uPhone = uPhone;
		this.uManager = uManager;
	}
	public Userksk(String uId, String uPw, String uName, String uSsn, String uPhone) {
		super();
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uSsn = uSsn;
		this.uPhone = uPhone;
	}
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuSsn() {
		return uSsn;
	}
	public void setuSsn(String uSsn) {
		this.uSsn = uSsn;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getuManager() {
		return uManager;
	}
	public void setuManager(String uManager) {
		this.uManager = uManager;
	}
//	toString 아직 안 만들었다.
}
