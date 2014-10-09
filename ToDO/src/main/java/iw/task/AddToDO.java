package iw.task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.google.gson.Gson;


public class AddToDO {
	
	public final static String DEFAULT_FILE_NAME = "toDO_list.json";

	// This function fills in a Person message based on user input.
	static ToDO PromptForAddress(BufferedReader stdin, PrintStream stdout)
			throws IOException {
		ToDO todo = new ToDO();

		stdout.print("Enter task name: ");
		todo.setTask(stdin.readLine());

		stdout.print("Enter context (blank for none): ");
		String context = stdin.readLine();
		if (context.length() > 0) {
			todo.setContext(context);
		}
		
		stdout.print("Enter project: ");
		todo.setProject(stdin.readLine());
		
		stdout.print("Enter task priority: ");
		todo.setPriority(Integer.valueOf(stdin.readLine()));

		return todo;
	}

	// Main function: Reads the entire address book from a file,
	// adds one person based on user input, then writes it back out to the same
	// file.
	public static void main(String[] args) throws Exception {
		String filename = DEFAULT_FILE_NAME;
		if (args.length > 0) {
			filename=args[0];
		}

		ToDOList toDoList = new ToDOList();
		Gson gson = new Gson();

		// Read the existing address book.
		try {
			toDoList = gson.fromJson(new FileReader(filename), ToDOList.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found.  Creating a new file.");
		}

		// Add an address.
		toDoList.addToDO(PromptForAddress(new BufferedReader(
				new InputStreamReader(System.in)), System.out));

		// Write the new address book back to disk.
		FileWriter output = new FileWriter(filename);
		output.write(gson.toJson(toDoList));
		output.close();
	}
}
