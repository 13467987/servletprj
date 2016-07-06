package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import jdbc.DBManager;
import vo.BoardVo;
import vo.ReplyVo;

public class BoardDao {
	private final static int LOGIN_OK = 1;
	private final static int LOGIN_FAIL = 0;

	public void create(BoardVo vo) {

		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		String query = "insert into board (userID,content,title,regDate) values(?,?,?,now())";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getTitle());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public ArrayList<BoardVo> read(BoardVo vo, int page) {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int size = 10;// 보여질 갯수
		int startRow = ((page - 1) * size);

		String query = "select *from board order by no desc limit ?,?";

		ArrayList<BoardVo> vos = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String userID = rs.getString("userID");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				Timestamp regDate = rs.getTimestamp("regDate");
				vo = new BoardVo(no, userID, title, content, regDate, hit);

				vos.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vos;
	}

	public BoardVo read(BoardVo vo, String boardNum) {

		upHit(boardNum);
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "select *from board where no=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(boardNum));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int no = rs.getInt("no");
				String userID = rs.getString("userID");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regDate = rs.getTimestamp("regDate");
				vo = new BoardVo(no, userID, title, content, regDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	private void upHit(String boardNum) {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		String query = "update board set hit=hit+1 where no=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(boardNum));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void update(BoardVo vo) {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		String query = "update board set title=?,content=? where no=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNo());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void delete(BoardVo vo) {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		String query = "delete from board where no=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vo.getNo());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public ArrayList<BoardVo> search(String search,String word,int page) {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo vo = null;
		ArrayList<BoardVo> vos = new ArrayList<>();
		
		int size = 10;// 보여질 갯수
		int startRow = ((page - 1) * size);

		String query = "select * from board where "+search+" like '%"+word+"%'";
		query +=" order by no desc limit ?,?";
		try {
			int i = 0;
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1,startRow);
			pstmt.setInt(2, size);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String userID = rs.getString("userID");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				Timestamp regDate = rs.getTimestamp("regDate");
				vo = new BoardVo(no, userID, title, content, regDate, hit);
				
				vos.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt,rs);
		}
		return vos;
	}

	public int pageCnt() {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int cnt = 0;

		try {
			pstmt = conn.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			if (rs.next())
				cnt = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return cnt;
	}

	public int pageCnt(String search,String word) {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt=0;

		String query = "select count(*) from board where "+search+" like '%"+word+"%'";
		try {
			int i = 0;
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next())
				cnt = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return cnt;
	}

	public int loginConfirm(String userID, String password) {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "select*from member where userID=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("password").equals(password))
					return LOGIN_OK;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return LOGIN_FAIL;
	}

	// 댓글 ----------------------------------------------------------
	public void create(ReplyVo vo) {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		String query = "insert into reply (userID,content,boardNum,regDate) values(?,?,?,now())";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardNum());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public ArrayList<ReplyVo> read(ReplyVo replyVo, String boardNum) {
		ArrayList<ReplyVo> vos = new ArrayList<>();

		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int num = Integer.parseInt(boardNum);

		String query = "select *from reply where boardNum=? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userID = rs.getString("userID");
				String content = rs.getString("content");
				Timestamp regDate = rs.getTimestamp("regDate");
				replyVo = new ReplyVo(userID, content, regDate);
				vos.add(replyVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vos;
	}
}
