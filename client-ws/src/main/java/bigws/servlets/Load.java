package bigws.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import bigws.soapserver.ToDOService;
import bigws.soapserver.ToDOServiceService;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/load" })
public class Load extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ToDOServiceService tss = new ToDOServiceService();
		ToDOService ts = tss.getToDOServicePort();
		String json=ts.lista();
		PrintWriter writer = resp.getWriter();
		writer.print(json);
		writer.flush();
		
		
	}

}
