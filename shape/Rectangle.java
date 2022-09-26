package sh.java.inheritance.shape;

import java.util.Arrays;

public class Rectangle extends Shape{
	
	Point leftTop ;
	Point rightTop;
	Point leftBottom;
	Point rightBottom;
	private Point [] points = {leftTop,rightTop,rightBottom,leftBottom};
	int width;
	int height ;
	
	
	public Rectangle() {
		
	}
	public Rectangle(Point[] points ) {
		this.points = points;
		
	}
	public Rectangle (Point leftTop, int width ,int height ) {
		this.leftTop = leftTop;
		this.width = width;
		this.height = height;
	}public Rectangle (Point leftTop, Point rightBottom) {
		this.leftTop = leftTop;
		this.rightBottom = rightBottom;
	}
	
	
	
	public Rectangle(Point [] point , int width, int height) {
		this.points =point;
		this.width =width;
		this.height =height;
		
		
	}
	
	
	
	public Point[] getPoints() {
		return points;
	}
	public void setPoints(Point[] points) {
		this.points = points;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public double getArea() {
		return width *height;
	}
		@Override 
		public String toString() {
			
			return "points= " + Arrays.toString(points)+ "width = " +width + "height = "+ height;
		}
	
	@Override
	public void draw() {
	
		System.out.println("네 꼭지점이"+Arrays.toString(points) +"이고"+ "너비가 "+this.width+"높이가"+this.height
				+"인 사각형을 그린다.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
