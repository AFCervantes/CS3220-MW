package models;

public class Assignment {

	static int count = 0;
	
	int id;
	String name;
	double score;
	
	public Assignment(String name, double score) {
		super();
		this.name = name;
		this.score = score;
		
		this.id = count++;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getId() {
		return id;
	}
	
	
	
}
