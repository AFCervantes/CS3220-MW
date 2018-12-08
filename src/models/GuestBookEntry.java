package models;
import java.util.Date;

public class GuestBookEntry {

	static int count = 0;
	
	int id;
	String name;
	String message;
	Date date;
	
	public GuestBookEntry() {
		super();
		this.id = count++;
		this.date = new Date();
	}
	public GuestBookEntry(int id, String name, String message) {
		super();
		this.name = name;
		this.message = message;
		this.id = id;
		this.date = new Date();
	}
	
	public GuestBookEntry(String name, String message) {
		super();
		this.name = name;
		this.message = message;
		this.id = count++;
		this.date = new Date();
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}
	
	
	
}
