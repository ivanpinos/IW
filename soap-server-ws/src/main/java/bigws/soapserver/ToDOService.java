package bigws.soapserver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
	public List<ToDO> lista() {
		ToDOList todolist;
		List<ToDO> list;
		Gson gson = new Gson();
		try {
			todolist = gson.fromJson(new FileReader(DEFAULT_FILE_NAME),
					ToDOList.class);
			list = todolist.getToDoList();
			System.out.println(list.size());
		} catch (Exception e) {
			list = new ArrayList<ToDO>();
		}
		return list;
	}

	/*
	 * Guarda los nuevos datos en el fichero
	 */
	@WebMethod()
	public void guardarCambios(List<ToDO> data) {
		Gson gson = new Gson();
		FileWriter output;
		ToDOList list = new ToDOList();
		try {
			list.setToDoList(data);
			output = new FileWriter(DEFAULT_FILE_NAME);
			output.write(gson.toJson(list));
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
