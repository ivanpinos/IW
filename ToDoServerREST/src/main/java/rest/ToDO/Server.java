package rest.ToDO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.Grizzly;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import com.google.gson.Gson;

public class Server {

	private static final Logger LOGGER = Grizzly.logger(Server.class);
	public final static String DEFAULT_FILE_NAME = "toDO_list.json";

	public static void main(String[] args) {
		LOGGER.setLevel(Level.FINER);
		ToDOList tdl = lista();
		URI uri = UriBuilder.fromUri("http://localhost/").port(8081).build();
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri,
				new ApplicationConfig(tdl));
		try {
			server.start();
			LOGGER.info("Press 's' to shutdown now the server...");
			while(true){
				int c = System.in.read();
				if (c == 's')
					break;
			}
		} catch (IOException ioe) {
			LOGGER.log(Level.SEVERE, ioe.toString(), ioe);
		} finally {
			server.stop();
			LOGGER.info("Server stopped");
		}
	}


	// Devuelve una lista con los elementos de .json.
	private static ToDOList lista() {
		ToDOList todolist;
		Gson gson = new Gson();
		try {
			todolist = gson.fromJson(new FileReader(DEFAULT_FILE_NAME),
					ToDOList.class);
		} catch (FileNotFoundException e) {
			System.out.println("NO hay fichero");
			return new ToDOList();
		}
		return todolist;
	}
}
