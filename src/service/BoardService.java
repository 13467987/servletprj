package service;

import java.util.ArrayList;

import dao.BoardDao;
import vo.BoardVo;
import vo.ReplyVo;

public class BoardService {
	BoardDao dao = new BoardDao();
	
	public void create(BoardVo vo) {
		dao.create(vo);
	}
	public void create(ReplyVo vo){
		dao.create(vo);
	}
	public ArrayList<BoardVo> read(BoardVo vo, int page){
		return dao.read(vo,page);
	}	public  BoardVo read(BoardVo vo,String boardNum){
		return dao.read(vo,boardNum);
	}
	
	
	public void update(BoardVo vo){
		dao.update(vo);
	}
	public void delete(BoardVo vo){
		dao.delete(vo);
	}
	public ArrayList<BoardVo> search(String search,String word,int page){
		return dao.search(search,word,page);
	}
	public int pageCnt() {
		return dao.pageCnt();
	}
	public int pageCnt(String search,String word){
		return dao.pageCnt(search,word);
	}
	public ArrayList<ReplyVo> read(ReplyVo replyVo, String boardNum) {
		return dao.read(replyVo,boardNum);
	}

}
