package co.micol.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.member.dao.MemberDao;

public class IdCheck implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDao dao = new MemberDao();
		String id = request.getParameter("memberId");
		boolean bool = dao.isIdCheck(id);
		String message = null;
		if(bool) {
			message = id + "사용 가능한 아이디";
		}else {
			message = id + "사용 불가 아이디";
		}
		request.setAttribute("msg", message);
		request.setAttribute("check", bool);
		
		
		return "view/member/idCheck";
	}

}
