package co.micol.book.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.web.BookDelete;
import co.micol.book.web.BookForm;
import co.micol.book.web.BookInfo;
import co.micol.book.web.BookInsert;
import co.micol.book.web.BookReturn;
import co.micol.book.web.BookUpdate;
import co.micol.book.web.AdminPage;
import co.micol.book.web.BookDecrease;
import co.micol.book.web.BooksList;
import co.micol.book.web.MainCommand;
import co.micol.member.web.IdCheck;
import co.micol.member.web.Login;
import co.micol.member.web.LoginFail;
import co.micol.member.web.LoginForm;
import co.micol.member.web.Logout;
import co.micol.member.web.MemberDelete;
import co.micol.member.web.MemberDeleteForm;
import co.micol.member.web.MemberJoin;
import co.micol.member.web.MemberJoinFail;
import co.micol.member.web.MemberJoinForm;
import co.micol.member.web.MemberList;
import co.micol.member.web.MemberPage;
import co.micol.book.web.BookUpdateForm;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/booksList.do", new BooksList());
		map.put("/bookForm.do", new BookForm());
		map.put("/bookInsert.do", new BookInsert());
		map.put("/bookInfo.do", new BookInfo());
		map.put("/bookDecrease.do", new BookDecrease());
		map.put("/bookUpdateForm.do", new BookUpdateForm());
		map.put("/bookUpdate.do", new BookUpdate());
		map.put("/bookDelete.do", new BookDelete()); //여기 까지가 책
		map.put("/adminPage.do", new AdminPage()); // 멤버 관련 기능
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new Login());
		map.put("/logout.do", new Logout());
		map.put("/loginFail.do", new LoginFail());
		map.put("/memberJoinForm.do", new MemberJoinForm());
		map.put("/memberJoin.do", new MemberJoin());
		map.put("/memberJoinFail.do", new MemberJoinFail());
		map.put("/memberPage.do", new MemberPage());
		map.put("/idCheck.do", new IdCheck());
		map.put("/memberList.do", new MemberList());
		map.put("/bookReturn.do", new BookReturn());
		map.put("/memberDeleteForm.do", new MemberDeleteForm());
		map.put("/memberDelete.do", new MemberDelete());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contexPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contexPath.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
