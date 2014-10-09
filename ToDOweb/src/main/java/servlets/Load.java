package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.google.gson.Gson;

import toDO.Lista;
import toDO.ToDO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/load" })
public class Load extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<ToDO> list = Lista.lista();
		String json="";
		if(list != null)
			json = new Gson().toJson(list);
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		writer.flush();
		
		
	}

}
