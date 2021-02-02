package co.micol.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.member.dao.MemberDao;
import co.micol.member.vo.MemberVo;

public class menuAuth implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberAuth(request.getParameter("memberId"));
		
		dao.select(vo);
		request.setAttribute("vo", vo);
		
		return "view/main/menu";
	}

}
