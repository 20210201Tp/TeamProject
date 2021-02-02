package co.micol.member.web;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;

public class LogoinForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "view/member/login";
	}

}
