package vo;

public class MemberVo {
	
	private int no;
	private String userID;
	private String password;
	private String phone1;
	private String phone2;
	private String phone3;
	
	
	public MemberVo() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberVo(String userID, String password) {
		super();
		this.userID = userID;
		this.password = password;
	}
	public MemberVo(int no, String userID, String password) {
		super();
		this.no = no;
		this.userID = userID;
		this.password = password;
	}
	public MemberVo(int no, String userID, String password, String phone1, String phone2, String phone3) {
		super();
		this.no = no;
		this.userID = userID;
		this.password = password;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	
	
	
}
