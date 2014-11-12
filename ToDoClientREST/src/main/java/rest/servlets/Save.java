package rest.servlets;


import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.ToDo.ToDOList;

import com.google.gson.Gson;



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
		ToDOList todolist = gson.fromJson("{toDoList:"+data+"}",ToDOList.class);
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8081/toDo")
		.request(MediaType.APPLICATION_JSON)
		.post(Entity.entity(todolist, MediaType.APPLICATION_JSON));
		resp.setStatus(response.getStatus());
	}

}
