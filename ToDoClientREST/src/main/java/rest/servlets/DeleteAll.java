package rest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/deleteAll" })
public class DeleteAll extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Client client = ClientBuilder.newClient();
		Response response = client
		.target("http://localhost:8081/toDo/removeTasks")
		.request(MediaType.APPLICATION_JSON).delete();
		resp.setStatus(response.getStatus());	
	}

}
