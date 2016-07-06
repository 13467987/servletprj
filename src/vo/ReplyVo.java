package vo;

import java.sql.Timestamp;

public class ReplyVo {
	
	private int no;
	private String userID;
	private String content;
	private int boardNum;
	private Timestamp regDate;
	
public ReplyVo() {
}
	
	public Timestamp getRegDate() {
	return regDate;
}

public void setRegDate(Timestamp regDate) {
	this.regDate = regDate;
}

	public ReplyVo(String userID, String content, Timestamp regDate) {
	this.userID = userID;
	this.content = content;
	this.regDate = regDate;
}

	public ReplyVo(String userID, String content, int boardNum,Timestamp regDate) {
	super();
	this.userID = userID;
	this.content = content;
	this.boardNum = boardNum;
	this.regDate = regDate;
}

	public ReplyVo(int no, String userID, String content, int boardNum) {
		super();
		this.no = no;
		this.userID = userID;
		this.content = content;
		this.boardNum = boardNum;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
	
}
