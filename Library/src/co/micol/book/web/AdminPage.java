package co.micol.book.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRntDao;
import co.micol.book.vo.BookRntVo;

public class AdminPage implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookRntDao rDao = new BookRntDao();
		ArrayList<BookRntVo> list = new ArrayList<BookRntVo>();
		
		list = rDao.selectList();
		request.setAttribute("list", list);
		
		return "view/book/adminPage";
	}

}
