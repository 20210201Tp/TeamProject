package co.micol.book.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookDao;
import co.micol.book.dao.BookRntDao;
import co.micol.book.vo.BookRntVo;
import co.micol.book.vo.BookVo;

public class BookDecrease implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		BookRntDao rDao = new BookRntDao();
		BookRntVo rVo = new BookRntVo();
		
		rVo.setMemberId(request.getParameter("memberId"));
		rVo.setBookCode(request.getParameter("bookCode"));
		
		rDao.check(rVo);
		System.out.println(rVo.getExpReturnDate());
		if(rVo.getExpReturnDate() != null) {
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.println("<script>alert('이미 해당 도서를 대출하셨습니다.');location.href='"+"booksList.do"+"';</script>");
				writer.close();
				response.sendRedirect("pagePath");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			PrintWriter writer;
			BookDao dao = new BookDao();
			BookVo vo = new BookVo();
			vo.setBookCode(request.getParameter("bookCode"));
			vo.setbCount(Integer.parseInt(request.getParameter("bCount")) - 1);
			
			dao.bCountUpDown(vo);
			
			rDao.insert(rVo);
			
			try {
				writer = response.getWriter();
				writer.println("<script>alert('대출 완료!');location.href='"+"booksList.do"+"';</script>");
				writer.close();
				response.sendRedirect("pagePath");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}