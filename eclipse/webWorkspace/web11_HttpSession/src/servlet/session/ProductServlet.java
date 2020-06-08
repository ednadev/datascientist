package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	/*
	 * 1.기존의 세션을 세션을 받아온다..
	 * 2. 세션에 바인딩된 값이 있다면....그 값을 찾아온다
	 * 3. 2번에서 받아온 정보를 여기서 출력...세션의 jsessionid값도 출력..기존의 것과 동일한지 확인
	 * 4. 상품정보를 하나 세션에 다시 바인딩..
	 * 5. 네비게이션...a href=CartServlet
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) { //로그인 성공 했다면...
			MemberVO rvo = (MemberVO) session.getAttribute("vo");
			out.println("JSESSIONID :: " + session.getId() + "<br>");
			out.println("VO :: " + rvo);
			
			session.setAttribute("pvo", "LG GRAM NOTEBOOK..<br>");
			out.println("<a href=CartServlet>CartServlet , 세번째 서블릿 페이지로 이동...</a>");
		} else { //로그인 실패 했다면...
			out.println("session 에 바인딩된 객체가 없습니다...로그인 실패!!");
			out.println("<a href=login.html>로그인 페이지로 이동</a>");
		}
	}

}
