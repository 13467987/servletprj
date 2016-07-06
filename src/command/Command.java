package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public String excute(HttpServletRequest req,HttpServletResponse res);
}
