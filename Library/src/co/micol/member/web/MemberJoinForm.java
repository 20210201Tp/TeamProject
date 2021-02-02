package co.micol.member.web;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;

public class MemberJoinForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String viewPage = "view/member/memberJoinForm";
		
		return viewPage;
	}

}
