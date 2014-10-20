package bigws.ToDO;

import javax.xml.bind.annotation.XmlTransient;

public class ToDO {
	
	public String getTask() {
		return task;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	public String getContext() {
		return context;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	
	public String getProject() {
		return project;
	}
	
	public void setProject(String project) {
		this.project = project;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@XmlTransient public String task;
	@XmlTransient public String context;
	@XmlTransient public String project;
	@XmlTransient public int priority;
	
	public boolean hasContext() {
		return context != null;
	}
	
}
