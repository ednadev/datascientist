package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//1. ajax01_count.html
		/*String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		out.print(id + " " + pass + "<br> <b>Count :: " + ++count +"</b>");*/
		
		//2. ajax02_Encoding.html
		String nick = request.getParameter("nick");
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			
		}
		
		out.print(nick); //응답이 여기서 간다...클라이언트로..
	}

}
