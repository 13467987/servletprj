package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.BoardVo;
import vo.ReplyVo;

public class ReplyAction implements Command {

	@Override
	public String excute(HttpServletRequest req, HttpServletResponse res) {
		ReplyVo vo = new ReplyVo();
		BoardService boardService = new BoardService();
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		
		vo.setUserID((String) req.getSession().getAttribute("userID"));
		vo.setContent(req.getParameter("content"));
		vo.setBoardNum(boardNum);
		
		boardService.create(vo);
		
		
		return "redirect:board.do?no="+boardNum;
	}

}
