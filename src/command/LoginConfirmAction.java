package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import service.LoginService;

public class LoginConfirmAction implements Command {

	@Override
	public String excute(HttpServletRequest req, HttpServletResponse res) {
		BoardService boardService =new BoardService();
		LoginService loginService = new LoginService();
		
		String userID = (String) req.getParameter("userID");
		String password = (String)req.getParameter("password");
		HttpSession session=req.getSession();
		
		int confirm =loginService.loginConfirm(userID,password);
		
		if(confirm == 1){
			session.setAttribute("userID",userID);
			return "/index.do";
		}else{
			req.setAttribute("error",0);
			return"/login.do";
		}
	}

}
