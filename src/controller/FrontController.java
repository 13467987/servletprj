package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import command.BoardAction;
import command.Command;
import command.CustomerAction;
import command.IndexAction;
import command.JoinAction;
import command.LoginAction;
import command.LoginConfirmAction;
import command.LogoutAction;
import command.ReplyAction;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	static Map actions;
	
	static {
		actions = new HashMap<>();
		actions.put("/index.do", new IndexAction());
		actions.put("/board.do", new BoardAction());
		actions.put("/logout.do", new LogoutAction());
		/*----------------새롭게 추가 --------------------------*/
		actions.put("/login.do", new LoginAction());
		actions.put("/loginConfirm.do",new LoginConfirmAction());
		actions.put("/customer.do", new CustomerAction());
		actions.put("/reply.do",new ReplyAction());
		actions.put("/joinForm.do",new JoinAction());
		actions.put("/join.do", new JoinAction());
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String actionName = req.getRequestURI();
		
		Command command = (Command) actions.get(actionName);
		String viewName = command.excute(req, res);

		boolean isRedirect = viewName.startsWith("redirect:");//앞이 redirect: 면
		
/*		if(req.getParameter("upfile") != null){
		int size = 1*1024*1024;
		String saveFolder = "resource/upload"; //파일이 저장 될 폴더 경로
		String savePath =""; 
		ServletContext context = getServletContext();
		
		savePath =context.getRealPath(saveFolder);//현재 JSP 상의 절대경로 
		
		MultipartRequest multi = new MultipartRequest(req, savePath,size,"utf-8",new DefaultFileRenamePolicy());
		
		String originalFileName = multi.getOriginalFileName("upfile");
		String fileName = multi.getFilesystemName("upfile");
		
		File file1 = multi.getFile("upfile");
		}*/

		if (isRedirect) {
			res.sendRedirect(viewName.replace("redirect:",""));//redirect 를 "" 없는 칸으로 치환
		}else{
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewName);
			dispatcher.forward(req, res);
		}
	
	}

}
