package bigws.soapserver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.google.gson.Gson;

import bigws.ToDO.ToDO;
import bigws.ToDO.ToDOList;


@WebService
public class ToDOService {

	public final static String DEFAULT_FILE_NAME = "toDO_list.json";
	
	// Devuelve una lista con los elementos de .json.
	@WebMethod()
	public String lista() {
		ToDOList todolist;
		List<ToDO> list;
		Gson gson = new Gson();
		try {
			todolist = gson.fromJson(new FileReader(DEFAULT_FILE_NAME),
					ToDOList.class);
			list = todolist.getToDoList();
		} catch (FileNotFoundException e) {
			list = null;
		}
		String json="";
		if(list != null)
			json = new Gson().toJson(list);
		return json;
	}

	/*
	 * Guarda los nuevos datos en el fichero
	 */
	@WebMethod()
	public void guardarCambios(String data) {
		ToDOList toDoList = new ToDOList();
		Gson gson = new Gson();
		toDoList = gson.fromJson(data, ToDOList.class);
		FileWriter output;
		try {
			output = new FileWriter(DEFAULT_FILE_NAME);
			output.write(gson.toJson(toDoList));
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
