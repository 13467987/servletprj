package command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Command {

	@Override
	public String excute(HttpServletRequest req, HttpServletResponse res) {
		
		req.getSession().invalidate();
	
		return "redirect:/login.do";
	}

}
