package sh.java.inheritance.shape;

public class Shape {
	
	//
	private double area; // 넓이
	
	public Shape () {}
	
	public Shape(double area) {
		this.area =area ;
		
	}
	public double getArea () {
		
		return this.area;
		
	}
	public void setArea(double area) {
		this.area = area;
	}
	
	public void draw() {
		System.out.println("도형을 그린다..");
		
	}
	
}
