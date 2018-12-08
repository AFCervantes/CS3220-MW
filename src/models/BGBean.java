package models;

public class BGBean {

	int red, green, blue;

	public BGBean() {
		super();
		
		red = 255;
		green = 0;
		blue = 0;
	}
	
	public int getR() {
		return red;
	}	

	public void setR(int r) {
		this.red = r;
	}

	public int getG() {
		return green;
	}

	public void setG(int g) {
		this.green = g;
	}

	public int getB() {
		return blue;
	}

	public void setB(int b) {
		this.blue = b;
	}
	
	
	
}
