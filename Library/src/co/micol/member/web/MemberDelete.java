package co.micol.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.book.common.Command;
import co.micol.member.dao.MemberDao;
import co.micol.member.vo.MemberVo;

public class MemberDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		dao.login(vo);
		
		String viewPage = "main.do";
		if (vo.getMemberAuth() != null) {
			dao = new MemberDao();
			dao.delete(vo);
			
			PrintWriter writer;
			try {
				writer = response.getWriter();
				
				HttpSession session = request.getSession();
				session.invalidate();
				
				writer.println("<script>alert('회원탈퇴가 정상적으로 완료되었습니다.'); location.href='"+viewPage+"';</script>");
				writer.close();
				response.sendRedirect("pagePath");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			viewPage = "memberPage.do";
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.println("<script>alert('회원탈퇴가 실패했습니다. 비밀번호를 확인해주세요.'); location.href='"+viewPage+"';</script>");
				writer.close();
				response.sendRedirect("pagePath");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return viewPage;
	}

}
