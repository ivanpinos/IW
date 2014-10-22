package bigws.ToDO;

import java.util.ArrayList;
import java.util.List;

public class ToDOList {

	private List<ToDO> toDoList = new ArrayList<ToDO>();

	public List<ToDO> getToDoList() {
		return toDoList;
	}

	public void setToDoList(List<ToDO> toDo) {
		this.toDoList = toDo;
	}

	public void addToDO(ToDO toDo) {
		toDoList.add(toDo);
	}
}