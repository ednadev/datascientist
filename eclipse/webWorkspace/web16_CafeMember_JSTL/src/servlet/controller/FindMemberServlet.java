package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//try {
			doProcess(request, response);
		//} catch (SQLException e) {
		//	System.out.println(e);
		//}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//try {
			doProcess(request, response);
		//} catch (SQLException e) {
		//	System.out.println(e);
		//}
	}
	
	//protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		/*MemberDAOImpl dao = MemberDAOImpl.getInstance();
		MemberVO vo = dao.findByIdMember(id);
		if(vo==null) {
			response.sendRedirect("find_fail.jsp");
		} else {
			request.setAttribute("id", vo);
			request.getRequestDispatcher("find_ok.jsp").forward(request, response);
		}*/
		
		String path = "find_fail.jsp";
		try {
			MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(id);
			if(vo!=null) {
				request.setAttribute("vo", vo);
				path = "find_ok.jsp";
			}
		} catch(SQLException e) {
			
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
