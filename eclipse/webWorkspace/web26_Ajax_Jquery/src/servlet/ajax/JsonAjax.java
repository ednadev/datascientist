package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Food;
//Json형식의 비동기 코드를 작성하려면....json 라이브러리가 필요하다..
@WebServlet("/JsonAjax")
public class JsonAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//JSONObject 객체를 하나 생성..json.jar가 필요하다
		
		JSONObject json = new JSONObject();
		
		//1.
		/*json.put("name", "Jason");
		json.put("age", 26);
		json.put("addr", "Texas");
		
		out.print(json);*/
		
		
		//2.
		/*Food food = new Food("바나나", 3000);
		ObjectMapper mapper = new ObjectMapper();
		String banana = mapper.writeValueAsString(food);

		json.put("banana", banana);
		out.print(json);*/
		Food food = new Food();
		food.setMaker("Banana");
		food.setPrice(2000);
		json.put("food", food);
		
		out.print(json);
		
	}

}
