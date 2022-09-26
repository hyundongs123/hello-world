package sh.java.inheritance.shape;

import java.util.Arrays;

public class Rectangle extends Shape{
   
   private Point leftTop ;
   private Point rightTop ;
   private Point rightBottom ;
   private Point leftBottom ;
   private Point [] points ={leftTop,rightTop,rightBottom,leftBottom};
   private int width = 0  ;
   private int height = 0;
   
   public Rectangle() {
      super();
   }
   public Rectangle(Point[] points ) {
      this.points = points;
      width = points [1].getX() - points[0].getX();
      height = points[3].getY() - points[0].getY();
      
   }
   public Rectangle(Point leftTop ,int width,int height) {
	   this.points[0] = leftTop;      
	   this.points[1] = new Point(leftTop.getX() + width,leftTop.getY() );
	   this.points[2] = new Point(leftTop.getX() + width, leftTop.getY() + height);
	   this.points[3] = new Point (leftTop.getX(), leftTop.getY() + height);
	   this.width  =width;
	   this.height = height;
   }

   public Rectangle(Point leftTop, Point rightBottom) {
       this.points[0] = leftTop;
       this.points[1] = new Point(rightBottom.getX(),leftTop.getY());
       this.points[2] = rightBottom;
       this.points[3] = new Point(leftTop.getX(),rightBottom.getY());
       width = points[1].getX() - points[0].getX();
       height = points[3].getY() - points[0].getY(); //Y는 밑으로 간다.
   }
   
   public Rectangle(Point[] points, int width, int height) {
	   this.points = points ;
	   this.width = width;
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
         
         return  "points = " +Arrays.toString(points)+ "width = "+width 
        		  + "height = "+ height;
      }
   
   @Override
   public void draw() {
		   System.out.println("네 꼭지점이 "+Arrays.toString(points) +"이고"+ "너비가 "+width+"높이가"+height
            +"인 사각형을 그린다.");
   }
}
   
   
   
   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
