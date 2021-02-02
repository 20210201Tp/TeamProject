package co.micol.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.book.common.DAO;
import co.micol.book.vo.BookVo;

public class BookDao extends DAO{
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<BookVo> selectList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		BookVo vo;
		String sql = "SELECT * FROM BOOK ORDER BY 1 DESC";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookVo();
				vo.setBookCode(rs.getString("bookcode"));
				vo.setBookName(rs.getString("bookname"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public BookVo select(BookVo vo) {
		String sql = "SELECT * FROM BOOK WHERE BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setBookCode(rs.getString("bookcode"));
				vo.setBookName(rs.getString("bookname"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	public int insert(BookVo vo) {
		int n = 0;
		String sql = "INSERT INTO BOOK(BOOKCODE, BOOKNAME) VALUES(? , ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getBookName());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	public int update(BookVo vo) {
		int n = 0;
		String sql = "UPDATE BOOK SET BOOKNAME = ? WHERE BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookName());
			psmt.setString(2, vo.getBookCode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	public int delete(BookVo vo) {
		int n = 0;
		String sql = "DELETE BOOK WHERE BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	public int bCountUpDown(BookVo vo) {
		int n = 0;
		String sql = "UPDATE BOOK SET BCOUNT = ? WHERE BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbCount());
			psmt.setString(2, vo.getBookCode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
