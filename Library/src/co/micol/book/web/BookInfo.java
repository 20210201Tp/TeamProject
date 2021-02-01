package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;

public class BookInfo implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		String str = request.getParameter("bookCode");
		String pad = "0000";
		String ans = pad.substring(0, pad.length() - str.length()) + str;
		vo.setBookCode(ans);
		
		dao.select(vo);
		request.setAttribute("vo", vo);
		
		return "view/book/bookInfo";
	}

}
