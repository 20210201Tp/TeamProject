package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;

public class BookDecrease implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		vo.setBookCode(request.getParameter("bookCode"));
		vo.setbCount(Integer.parseInt(request.getParameter("bCount")) - 1);
		
		dao.bCountUpDown(vo);
		
		return "booksList.do";
	}

}
