package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	/*
	 * 1. 폼값 받아서
	 * 2. vo 생성..pvo
	 * 3. DAO리턴 받아서...updateMember()호출
	 * 4. 수정된 정보를 반드시 세션에 바인딩////
	 * 5. 네비게이션....update_result.jsp..<a>다시 index.jsp<a>로
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		MemberVO pvo = new MemberVO(id, password, name, address);

		try {
			MemberDAOImpl.getInstance().updateMember(pvo);
			
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", pvo); //중요
			}
			request.getRequestDispatcher("update_result.jsp").forward(request, response);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
