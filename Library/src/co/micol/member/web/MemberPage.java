package co.micol.member.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.book.common.Command;
import co.micol.book.dao.BookRntDao;
import co.micol.book.vo.BookRntVo;

public class MemberPage implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<BookRntVo> list = new ArrayList<BookRntVo>();
		BookRntDao dao = new BookRntDao();
		BookRntVo vo = new BookRntVo();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sMemberId");
		vo.setMemberId(id);
		list = dao.select(vo);
		request.setAttribute("list", list);

		return "view/member/memberPage";
	}
}
