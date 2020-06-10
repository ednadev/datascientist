package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;
/*
 * <servlet>
 *   <servlet-name>DispatcherServlet</servlet-name>
 *   <servlet-class>servlet.controller.DispatcherServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 *   <servlet-name>DispatcherServlet</servlet-name>
 *   <url-pattern>front.do</url-pattern>
 * </servlet-mapping>
 */
@WebServlet(urlPatterns="/front.do", loadOnStartup=1)
public class DispatcherServlet extends HttpServlet {
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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//요청이 어디에서 들어온 요청인지를 .....command값 받는다
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		if(command.equals("register")) {
			path = register(request, response);
		}else if(command.equals("find")) {
			path = find(request, response);
		}else if(command.equals("idcheck")) {
			path = idcheck(request, response);
		}else if(command.equals("allMember")) {
			path = allMember(request, response);
		}else if(command.equals("login")) {
			path = login(request, response);
		}else if(command.equals("logout")) {
			path = logout(request, response);
		}else if(command.equals("update")) {
			path = update(request, response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);	
	}//doProcess
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo  = new MemberVO(id, password, name, address);
		MemberDAOImpl.getInstance().registerMember(pvo);
		return "index.jsp";
	}
	
	protected String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		MemberVO vo=MemberDAOImpl.getInstance().findByIdMember(id);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			return "find_ok.jsp";
		}		
		return "find_fail.jsp";
			
	}
	
	protected String idcheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		boolean flag = MemberDAOImpl.getInstance().idExist(id);
		request.setAttribute("flag", flag);
		return "idcheck.jsp";
	}
	
	protected String allMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		ArrayList<MemberVO> list=MemberDAOImpl.getInstance().showAllMember();
		request.setAttribute("list", list);
		return "allView.jsp";
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVO rvo=MemberDAOImpl.getInstance().login(id, password);
		HttpSession session = request.getSession();
		
		if(rvo !=null ) {
			session.setAttribute("vo", rvo);
			System.out.println("JSESSIONID :: "+session.getId());
			return "login_result.jsp";
		}
		return null;
	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		//로그아웃 로직을 작성....invalidate()
		HttpSession session = request.getSession();
		
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			return "logout.jsp";
		}
		return null;
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
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
		return "update_result.jsp";
	}

}
