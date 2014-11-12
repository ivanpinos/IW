package rest.ToDO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

/**
 * A service that manipulates ToDOs in a toDo list.
 *
 */
@Path("/toDo")
public class ToDoListService {
	
	public final static String DEFAULT_FILE_NAME = "toDO_list.json";

	/**
	 * The (shared) todo list object. 
	 */
	@Inject
	ToDOList todolist;

	/**
	 * A GET /toDO request should return the toDo list in JSON.
	 * @return a JSON representation of the toDo list.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ToDOList getToDOList() {
		return todolist;
	}

	/**
	 * A POST /toDo request should save the toDo list.
	 * @param info the URI information of the request
	 * @param toDolist the list to save.
	 * @return a JSON representation of the saved list that should be available at /toDO/savedList.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveList(@Context UriInfo info,ToDOList toDolist) {
		todolist.setToDoList(toDolist.getToDoList());
		guardarCambios();
		toDolist.setHref(info.getAbsolutePathBuilder().path("savedList").build(toDolist));
		return Response.created(toDolist.getHref()).entity(toDolist).build();
	}
	
	/**
	 * A DELETE /toDo/removeTasks should delete the entries of the list.
	 * @return 200 if the request is successful.
	 */
	@DELETE
	@Path("removeTasks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeTasks() {
		todolist.setToDoList(new ArrayList<ToDO>());
		guardarCambios();
		return Response.ok().build();
	}
	
	
		/*
		 * Guarda los nuevos datos en el fichero
		 */
		private void guardarCambios() {
			Gson gson = new Gson();
			FileWriter output;
			try {
				output = new FileWriter(DEFAULT_FILE_NAME);
				output.write(gson.toJson(todolist));
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}


}
