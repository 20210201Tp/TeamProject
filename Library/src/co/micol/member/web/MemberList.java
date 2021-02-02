package co.micol.member.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.common.Command;
import co.micol.member.dao.MemberDao;
import co.micol.member.vo.MemberVo;

public class MemberList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		MemberDao dao = new MemberDao();
		
		list = dao.selectList();
		request.setAttribute("list", list);
		
		return "view/member/memberList";
	}

}
