package practice.todos;

public class Todo {

	static int count = 0;
	
	int id;
	String description;
	boolean done;
	
	public Todo(String description) {
		super();
		this.description = description;
		this.done = false;
		this.id = count++;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isDone() {
		return done;
	}
	

	public void setDone(boolean done) {
		this.done = done;
	}

	public int getId() {
		return id;
	}
	
	
	
}
