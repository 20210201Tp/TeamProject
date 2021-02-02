package co.micol.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.book.common.Command;
import co.micol.member.dao.MemberDao;
import co.micol.member.vo.MemberVo;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo = dao.login(vo);


		if (vo.getMemberAuth() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", vo.getMemberId());
			session.setAttribute("mAuth", vo.getMemberAuth());
			request.setAttribute("vo", vo);
		}
		return "view/member/login";
	}
}
