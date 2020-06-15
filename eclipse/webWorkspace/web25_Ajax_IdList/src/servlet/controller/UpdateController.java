package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		MemberVO pvo = new MemberVO(id, password, name, address);

		MemberDAOImpl.getInstance().updateMember(pvo);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
			session.setAttribute("vo", pvo); //중요
		}
		return new ModelAndView("update_result.jsp");
	}

}
