package practice.email;

import java.util.Date;

public class Subscriber {

	static int count = 0;
	
	int id;
	String email;
	Date date;
	
	public Subscriber(String email) {
		super();
		this.email = email;
		this.date = new Date();
		this.id = count++;		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}
	
	
	
	
	
}
