package rest.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.ToDo.ToDOList;

import com.google.gson.Gson;



@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/load" })
public class Load extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Client client = ClientBuilder.newClient();
		Response response = client
		.target("http://localhost:8081/toDo")
		.request(MediaType.APPLICATION_JSON).get();
		PrintWriter writer = resp.getWriter();
		ToDOList todolist = response.readEntity(ToDOList.class);

		if(!todolist.isEmpty()){
			writer.print(new Gson().toJson(todolist.getToDoList()));
		}
		else
			writer.print("");
		writer.flush();
		
		
	}

}
