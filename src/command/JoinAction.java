package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.MemberVo;

public class JoinAction implements Command {

	@Override
	public String excute(HttpServletRequest req, HttpServletResponse res) {
		MemberService memberService = new MemberService();
		
		if(req.getRequestURI().equals("/join.do")){
			MemberVo vo = new MemberVo();
			vo.setUserID(req.getParameter("userID"));
			if(memberService.idCheck(vo)==0){
				req.setAttribute("error",0);
				return "/WEB-INF/view/login/join_form.jsp";
			}else{
				vo.setPassword(req.getParameter("password"));
				vo.setPhone1(req.getParameter("phone1"));
				vo.setPhone2(req.getParameter("phone2"));
				vo.setPhone3(req.getParameter("phone3"));
				memberService.create(vo);
			}
			
			return "redirect: index.do";
		}else{			
			return "/WEB-INF/view/login/join_form.jsp";
		}
	}

}
