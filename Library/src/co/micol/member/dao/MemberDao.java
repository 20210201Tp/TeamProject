package co.micol.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.book.common.DAO;
import co.micol.member.vo.MemberVo;

public class MemberDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<MemberVo> selectList(){
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		MemberVo vo;
		String sql = "SELECT * FROM MEMBER ORDER BY MEMBERID DESC";
		
		try {
			 psmt = conn.prepareStatement(sql);
			 rs = psmt.executeQuery();
			 	while(rs.next()) {
			 		vo = new MemberVo();
			 		vo.setMemberId(rs.getString("memberid"));
			 		vo.setMemberName(rs.getString("membername"));
			 		vo.setMemberPassword(rs.getString("memberpassword"));
			 		vo.setMemberTel(rs.getString("membertel"));
			 		vo.setMemberAddress(rs.getString("memberaddress"));
			 		vo.setMemberAuth(rs.getString("memberauth"));
			 		
			 		list.add(vo);
			 	}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}
	 
	public int insert(MemberVo vo) {
		String sql = "INSERT INTO MEMBER(MEMBERID, MEMBERNAME, MEMBERPASSWORD, MEMBERTEL, MEMBERADDRESS) VALUES(?, ?, ?, ?, ?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberPassword());
			psmt.setString(4, vo.getMemberTel());
			psmt.setString(5, vo.getMemberAddress());
			
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	 
	
	public boolean isIdCheck(String id) {
		boolean bool = true;
		String sql = "SELECT MEMBERID FROM MEMBER WHERE MEMBERID=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				bool = false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	return bool;
	
	}
	
	public MemberVo login(MemberVo vo) { 
		String sql = "SELECT * FROM MEMBER WHERE MEMBERID=? AND MEMBERPASSWORD=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberPassword(rs.getString("memberpassword"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public MemberVo select(MemberVo vo) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBERID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberId(rs.getString("memberid"));
		 		vo.setMemberName(rs.getString("membername"));
		 		vo.setMemberAuth(rs.getString("memberauth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	
	private void close() {
		try {
				if(rs != null) rs.close();
				if(psmt != null)psmt.close();
				if(conn != null)psmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} 
}
