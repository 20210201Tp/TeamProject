package co.micol.book.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookDao;
import co.micol.book.vo.BookVo;

public class BooksList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookDao dao = new BookDao();
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		
		list = dao.selectList();
		request.setAttribute("list", list);
		return "view/book/booksList";
	}
}
