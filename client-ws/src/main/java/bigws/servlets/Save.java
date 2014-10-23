package bigws.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bigws.soapserver.ToDO;
import bigws.soapserver.ToDOService;
import bigws.soapserver.ToDOServiceService;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/save" })
public class Save extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		String data = reader.readLine();
		reader.close();
		Gson gson = new Gson();
		ToDO[] todolist = gson.fromJson(data,ToDO[].class);
		List<ToDO> list = Arrays.asList(todolist);
		ToDOServiceService tss = new ToDOServiceService();
		ToDOService ts = tss.getToDOServicePort();
		ts.guardarCambios(list);
	}

}
