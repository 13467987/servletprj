package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerAction implements Command {

	@Override
	public String excute(HttpServletRequest req, HttpServletResponse res) {
		return "/WEB-INF/view/customer/customer.jsp";
	}

}
