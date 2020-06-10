package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	/*
	 * 1.폼값 받아온다...
	 * 2. DAO리턴 받아서...BIZ 호출...BOOLEAN
	 * 3. 바인딩
	 * 4. 네비게이션...idcheck.jsp
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		boolean flag = MemberDAOImpl.getInstance().idExist(id);
		request.setAttribute("flag", flag);
		request.getRequestDispatcher("idcheck.jsp").forward(request, response);
	}

}
