package iw.task;

import java.io.FileReader;

import com.google.gson.Gson;


class ListaTareas {
	public final static String DEFAULT_FILE_NAME = "toDO_list.json";

	// Iterates though all toDO in the ToDOList and prints info about them.
	static void Print(ToDOList toDoList) {
		for (ToDO toDo : toDoList.getToDoList()) {
			System.out.println("Task: " + toDo.getTask());
			if (toDo.hasContext()) {
				System.out.println(" Context: " + toDo.getContext());
			}
			System.out.println("Project: " + toDo.getProject());
			System.out.println("Priority: " + toDo.getPriority());
		}
	}

	// Main function: Reads the entire toDO list from a file and prints all
	// the information inside.
	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		if (args.length > 0) {
			filename = args[0];
		}

		// Read the existing toDO list.
		ToDOList toDOList = gson.fromJson(new FileReader(
				filename), ToDOList.class);

		Print(toDOList);
	}
}
