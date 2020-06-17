package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command"); //subject
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		ModelAndView mv = null;
		
		try {
			mv = controller.handle(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		if(mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(mv.getPath());
			else request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}
	}

}
