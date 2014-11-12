package rest.ToDO;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

	/**
     * Default constructor
     */
    public ApplicationConfig() {
    	this(new ToDOList());
    }


    /**
     * Main constructor
     * @param toDoList a provided toDo list
     */
    public ApplicationConfig(final ToDOList toDoList) {
    	register(ToDoListService.class);
    	register(MOXyJsonProvider.class);
    	register(new AbstractBinder() {

			@Override
			protected void configure() {
				bind(toDoList).to(ToDOList.class);
			}});
	}	

}
