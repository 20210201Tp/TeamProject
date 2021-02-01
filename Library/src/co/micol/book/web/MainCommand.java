package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;

public class MainCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "view/main/main";
	}

}
