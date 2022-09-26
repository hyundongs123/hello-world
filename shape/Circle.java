package sh.java.inheritance.shape;

/**
 * 
 * Circle | Shape
 * - 일반화관계 : Circle에서 Shape으로 일반화(추상화) 되었다.
 * - Circle이 Shape을 상속한다.
 * - Circle is a Shape. -> is - a 상속관계
 * - 부모클래스의 멤버(필드/메소드)를 자식클래스인 것처럼 사용가능
 * - 하나의 클래스만 상속가능
 * 
 * Circle | Point
 *  - Circle이 Point를 필드로 가지고 있다.(연관관계)
 *  - Circle has a Point. -> has - a 포함관계 
 *  - Point필드의 기능을 필드.메소드호출을 통해 이용가능.
 *	- 개수제한없이 필드를 가질 수 있다.
 *  - 
 *
 *Method Overriding
 * - 상속받은 부모메서드를 재작성하는 것
 * - 메소드시그니쳐 (접근제한자,리턴타입,메소드명,매개변수선언,예외)이 모두 동일해야 한다.
 *   - @Override 어노테이션을 통해 컴파일타임에 체크.
 * - 접근제한자는 상속받은 것보다 더 개방할 수 있다.
 *   -  default < protected < public
 * - private/final 메소드는 override가 불가능하다.
 * - 선언부 예외를 일부만 던지거나, 제거할 수 있다.
 * - 
 *
 *
 */
public class Circle extends Shape{
	private Point center; //중심점
	private int r; //반지름
	
	public Circle () {}
	
	public Circle (Point center , int r) {
		this.center = center;
		this.r = r;
	}
	
	public Point getCenter( ) {
		return this.center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getR () {
		return this.r;
	}
	public void setR(int r) {
		this.r =r;
	}
	@Override
	public double getArea() {
		return r*r *Math.PI ;
	}
	
	@Override
	public void draw () {
		System.out.println("중심점이 "+this.center+"이고, 반지름이"
				+ this.r +"인 원을 그린다..");
	}
	
	
}
