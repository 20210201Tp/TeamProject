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
import co.micol.book.web.BookUpdate;
import co.micol.book.web.AdminPage;
import co.micol.book.web.BookDecrease;
import co.micol.book.web.BooksList;
import co.micol.book.web.MainCommand;
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
		map.put("/bookDelete.do", new BookDelete());
		map.put("/adminPage.do", new AdminPage());
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
