package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import jdbc.DBManager;
import vo.MemberVo;

public class MemberDao {
	private final static int ID_OK =1;
	private final static int ID_FAIL=0;
	
	
	public int idCheck(MemberVo vo) {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query ="select *from member where userID=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,vo.getUserID());
			rs=pstmt.executeQuery();
			if(rs.next()){
				return ID_FAIL;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return ID_OK;
	}


	public void create(MemberVo vo) {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		String query ="insert into member (userID,password,phone1,phone2,phone3) values(?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,vo.getUserID());
			pstmt.setString(2,vo.getPassword());
			pstmt.setString(3,vo.getPhone1());
			pstmt.setString(4,vo.getPhone2());
			pstmt.setString(5,vo.getPhone3());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	
/////////////////////테스트

	public int memID(String userid) {
		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(userid);
		String query = "select*from member where userID=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,userid);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				return ID_FAIL;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return ID_OK;
	}
	
}
