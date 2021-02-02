package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.book.dao.BookDao;
import co.micol.book.dao.BookRntDao;
import co.micol.book.vo.BookRntVo;
import co.micol.book.vo.BookVo;

public class BookReturn implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BookRntDao dao = new BookRntDao();
		BookRntVo vo = new BookRntVo();
		
		String str = request.getParameter("bookCode");
		String pad = "0000";
		String ans = pad.substring(0, pad.length() - str.length()) + str;
		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setBookCode(ans);
		dao.returnBook(vo);
		
		BookDao bDao = new BookDao();
		BookVo bVo = new BookVo();
		bVo.setBookCode(ans);
		bDao.select(bVo);
		System.out.println(bVo.getbCount());
		bVo.setbCount(bVo.getbCount() + 1);
		
		BookDao bao = new BookDao();
		bao.bCountUpDown(bVo);
		
		return "main.do";
	}

}
