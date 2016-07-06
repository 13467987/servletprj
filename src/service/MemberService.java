package service;

import dao.MemberDao;
import vo.MemberVo;

public class MemberService {
	MemberDao dao = new MemberDao();
	
	public int idCheck(MemberVo vo){
		return dao.idCheck(vo);
	}

	public void create(MemberVo vo) {
		dao.create(vo);
	}
}
