package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ControllerFactory;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성...
		String command = request.getParameter("command");
		String path = "error.jsp";
		
		Controller controller = ControllerFactory.getInstance().createController(command);
		try {
			path = controller.execute(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
		request.getRequestDispatcher(path).forward(request, response);	
	}

}
