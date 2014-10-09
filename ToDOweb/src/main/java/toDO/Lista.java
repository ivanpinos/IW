package toDO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;


public class Lista {
	
	public final static String DEFAULT_FILE_NAME = "toDO_list.json";


	//Devuelve una lista con los elementos de .json.
	public static List<ToDO> lista()  {
		ToDOList todolist;
		List<ToDO> list;
		Gson gson = new Gson();
		try{
			todolist = gson.fromJson(new FileReader(
					DEFAULT_FILE_NAME), ToDOList.class);
			list = todolist.getToDoList();
		}catch(FileNotFoundException e){
			list = null;
			System.out.println("FALLO");
		}
		return list;
	}
	
	/*
	 * Guarda los nuevos datos en el fichero
	 */
	public static void guardarCambios(String data){
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
