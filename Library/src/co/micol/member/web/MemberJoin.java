package co.micol.member.web;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.member.vo.MemberVo;
import co.micol.member.dao.MemberDao;

public class MemberJoin implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAddress(request.getParameter("memberAddress"));
		
		int n = dao.insert(vo);
		String viewPage = null;
		request.setAttribute("vo", vo);
		if(n != 0) {
			viewPage = "view/member/memberJoinSuccess";
		}else {
			viewPage = "view/member/memberJoinFail";
		}
		return viewPage;
	}

}
