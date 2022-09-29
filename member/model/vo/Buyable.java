package member.model.vo;

public interface Buyable {
	double SILVER = 0.02;
	double GOLD = 0.05;
	double VIP = 0.1;
	double VVIP = 0.15;
	double RUBY = 0.3;
	
	int buy (int price);
	
}
