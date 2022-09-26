package member.model.vo;

public class Gold extends Member{
	
	public Gold() {}
	public Gold(String name, String grade, int point) {
		super(name,grade,point);
	}
	
	public double getEjapoint() {
		return getPoint()*0.05;
	}
}
