package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		boolean flag = MemberDAOImpl.getInstance().idExist(id);
		request.setAttribute("flag", flag);
		return new ModelAndView("idcheck.jsp");
	}

}
