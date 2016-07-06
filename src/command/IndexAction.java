package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction implements Command {

	@Override
	public String excute(HttpServletRequest req, HttpServletResponse res) {
		return "/WEB-INF/view/index.jsp";
	}

}
