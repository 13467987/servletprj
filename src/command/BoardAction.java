package command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.BoardService;
import vo.BoardVo;
import vo.ReplyVo;

public class BoardAction implements Command {

	@Override
	public String excute(HttpServletRequest req, HttpServletResponse res) {

		BoardService boardService = new BoardService();
		ArrayList<BoardVo> vos = new ArrayList<>();
		BoardVo vo = new BoardVo();
		ArrayList<ReplyVo> replyVos = new ArrayList<>();
		ReplyVo replyVo = new ReplyVo();

		vo.setUserID((String) req.getSession().getAttribute("userID"));

		String boardNum = req.getParameter("no");
		String action = req.getParameter("action");
		
		String searchFlag = null;
		String search = null;
		String word = null;

		int page = 1; // 기본 페이지
		int totalCnt = boardService.pageCnt();

		if (req.getParameter("page") != null) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		vos = boardService.read(vo, page);

		if (boardNum != null) {
			vo = boardService.read(vo, boardNum);
			replyVos = boardService.read(replyVo, boardNum);

			req.setAttribute("vo", vo);
			req.setAttribute("reply", replyVos);

			return "WEB-INF/view/board/content.jsp";
		}
		if (action != null && action.equals("boardWrite")) {
			return "WEB-INF/view/board/board_write.jsp";
		}
		if (action != null && action.equals("write")) {
			MultipartRequest multi=null;
			int size = 1*1024*1024;
			String saveFolder = "resource/upload"; //파일이 저장 될 폴더 경로
			String savePath =""; 
			ServletContext context = req.getServletContext();
			savePath =context.getRealPath(saveFolder);//현재 JSP 상의 절대경로 
			try {
				multi = new MultipartRequest(req, savePath,size,"utf-8",new DefaultFileRenamePolicy());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//multipart/form-data  폼은 request.getParameter로 못가져옴
			vo.setTitle(multi.getParameter("title"));
			vo.setContent(multi.getParameter("content"));
			
			String originalFileName = multi.getOriginalFileName("upfile");
			String fileName = multi.getFilesystemName("upfile");
			
			File file1 = multi.getFile("upfile");
			
			vo.setUserID((String) req.getSession().getAttribute("userID"));
			boardService.create(vo);
			
			//TODO 경로를 DB에 저장 해서 부르고 하는 법..
			
			return "redirect:board.do";
		}
		if (action != null && action.equals("modifyForm")) {
			boardNum = req.getParameter("a");
			vo = boardService.read(vo, boardNum);
			req.setAttribute("vo", vo);
			return "WEB-INF/view/board/board_modify.jsp";
		}
		if (action != null && action.equals("modify")) {
			vo.setTitle(req.getParameter("title"));
			vo.setContent(req.getParameter("content"));
			vo.setNo(Integer.parseInt(req.getParameter("a")));

			boardService.update(vo);
			return "redirect: board.do";
		}
		if (action != null && action.equals("delete")) {
			boardNum = req.getParameter("a");

			vo.setNo(Integer.parseInt(boardNum));
			boardService.delete(vo);
			return "redirect:board.do";
		}
		if (req.getParameter("searchFlag") != null) {
			/*---------------------검색-------------*/

			searchFlag = req.getParameter("searchFlag");
			search = req.getParameter("search");
			word = req.getParameter("word");
			try {
				word=new String(word.getBytes("8859_1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			vos = boardService.search(search,word, page);
			totalCnt = boardService.pageCnt(search, word);
		}
		/*-------------------------------------------*/

		int listCnt = 5;// 쪽 번호 갯수

		// totalCnt는 전체 데이터 게시글 갯수.
		int totalPage = totalCnt / 10; // 10은 보여질 게시글 수

		if (totalCnt % 10 > 0) {
			totalPage++;
		}
		if (page > totalPage) {
			page = totalPage;
		}
		int startPage = (page - 1) / listCnt * listCnt + 1;
		int endPage = startPage + listCnt - 1;

		if (endPage > totalPage) {
			endPage = totalPage;
		}
		Map<String, Integer> pageData = new HashMap<>();
		pageData.put("startPage", startPage);
		pageData.put("endPage", endPage);
		pageData.put("totalPage", totalPage);
		pageData.put("page", page);

		req.setAttribute("pageData", pageData);

		if (page == 0) {
			req.setAttribute("hasNoPage", page);
		}
		req.setAttribute("vos", vos);
		req.setAttribute("searchFlag", searchFlag);
		req.setAttribute("search", search);
		req.setAttribute("word", word);

		return "WEB-INF/view/board/board.jsp";
	}
}
