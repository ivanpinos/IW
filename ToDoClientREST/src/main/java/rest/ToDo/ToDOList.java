package rest.ToDo;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ToDOList {

	private List<ToDO> toDoList = new ArrayList<ToDO>();
	private URI href;

	public List<ToDO> getToDoList() {
		return toDoList;
	}

	public void setToDoList(List<ToDO> toDo) {
		this.toDoList = toDo;
	}

	public void addToDO(ToDO toDo) {
		toDoList.add(toDo);
	}

	public URI getHref() {
		return href;
	}

	public void setHref(URI href) {
		this.href = href;
	}
	
	public boolean isEmpty(){
		return toDoList.size() == 0;
	}
}