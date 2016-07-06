package vo;

import java.sql.Timestamp;

public class BoardVo {
	private int no;
	private String userID;
	private String title;
	private String content;
	private Timestamp regDate;
	private int hit;
	
	public BoardVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public BoardVo(String userID, String title, String content) {
		super();
		this.userID = userID;
		this.title = title;
		this.content = content;
	}


	public BoardVo(int no, String userID, String title, String content, Timestamp regDate, int hit) {
		super();
		this.no = no;
		this.userID = userID;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
	}



	public BoardVo(int no, String userID, String title, String content, Timestamp regDate) {
		super();
		this.no = no;
		this.userID = userID;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	

}
