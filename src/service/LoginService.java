package service;

import dao.BoardDao;

public class LoginService {
	BoardDao dao = new BoardDao();
	
	public int loginConfirm(String userID, String password) {
		return dao.loginConfirm(userID,password);
	}
}
