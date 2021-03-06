package servlet.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WordEncoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼값 받아서
		 * 2. 받은 값을 수정한후
		 * 3. 다시 웹브라우저로 전송...출력
		 */
		String wName = request.getParameter("word"); //form의 name
		wName += "...update Server Side";
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Client Send Data...<br/>");
		out.println(wName + "</h2></body></html>");
		
		out.close();
	}

}
