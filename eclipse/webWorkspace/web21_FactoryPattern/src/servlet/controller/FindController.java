package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		
		MemberVO vo=MemberDAOImpl.getInstance().findByIdMember(id);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			path = "find_ok.jsp";
		}
			
		return path;
	}

}
