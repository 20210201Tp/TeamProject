package co.micol.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.book.common.DAO;
import co.micol.book.vo.BookRntVo;

public class BookRntDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	public ArrayList<BookRntVo> selectList() {
		ArrayList<BookRntVo> list = new ArrayList<BookRntVo>();
		BookRntVo vo;
		String sql = "SELECT * FROM BOOKRENTAL ORDER BY MEMBERID";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BookRntVo();
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getString("returndate"));
				vo.setExpReturnDate(rs.getString("expreturndate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public ArrayList<BookRntVo> select(BookRntVo vo) {
		ArrayList<BookRntVo> list = new ArrayList<BookRntVo>();
		String sql = "SELECT * FROM BOOKRENTAL WHERE MEMBERID = ? ORDER BY RENTALDATE";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BookRntVo();
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getString("returndate"));
				vo.setExpReturnDate(rs.getString("expreturndate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public int insert(BookRntVo vo) {
		int n = 0;
		String sql = "INSERT INTO BOOKRENTAL(RENTALDATE, BOOKCODE, MEMBERID) VALUES(sysdate , ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getMemberId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public int returnBook(BookRntVo vo) {
		int n = 0;
		String sql = "UPDATE BOOKRENTAL SET RETURNDATE = SYSDATE WHERE MEMBERID = ? AND BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getBookCode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public int delete(BookRntVo vo) {
		int n = 0;
		String sql = "DELETE BOOKRENTAL WHERE MEMBERID = ? AND BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getBookCode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	public BookRntVo check(BookRntVo vo) {
		String sql = "SELECT * FROM BOOKRENTAL WHERE MEMBERID = ? AND BOOKCODE = ? AND RETURNDATE IS NULL";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getBookCode());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getString("returndate"));
				vo.setExpReturnDate(rs.getString("expreturndate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
