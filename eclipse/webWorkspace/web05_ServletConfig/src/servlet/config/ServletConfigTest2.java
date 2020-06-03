package servlet.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path;
       
	public void init() throws ServletException {
		//1.ServletConfig의 기능을 사용해서 path에 연결된 값을 받아온다..
		path = getInitParameter("path");
		try {
			//2. BufferedReader를 사용해서 파일을 읽어들인다..
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			//3. count값으로 필드 초기화
			count = Integer.parseInt(br.readLine());
			br.close();
		}catch(Exception e) {
			System.out.println("파일을 읽어들이는데 실패...");
		}
	}
	
	@Override
	public void destroy() {
		File file = new File(path);
		file.getParentFile().mkdirs();
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.println(count);
			pw.close();
		} catch(IOException e) {
			System.out.println("스트림 생성 실패...");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기다가...
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 4. 폼에 입력된 값 받아서...
		// ~~아무개 님은 ~ 몇번째 입장하신 고객입니다...
		// 를 브라우저로 출력
		String userName = request.getParameter("userName");
		
		PrintWriter out = response.getWriter();
		out.println("<a href=config2.jsp?userName=" + userName + "&count=" + ++count + ">config2.jsp로 이동</a>");
		out.close();
	}
}
