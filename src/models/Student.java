package models;

import java.util.ArrayList;

public class Student {

	static int count = 0;
	
	int id;
	String name;
	String email;
	String password;
	
	ArrayList<Assignment> assignments;
	
	public Student(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		
		this.id = count++;
		
		this.assignments = new ArrayList<Assignment>();
	}

	public void addAssignment(String name, double score) {
		this.assignments.add(new Assignment(name, score));
	}
	
	public ArrayList<models.Assignment> getAssignments(){
		return assignments;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	
	
}