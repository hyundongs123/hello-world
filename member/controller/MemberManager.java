package member.controller;

import member.model.vo.Member;

public class MemberManager  {
	public static final int MAX_MEMBER = 40;
	private Member[] memberArr = new Member[MAX_MEMBER];
	private int memberIndex = 0;
	
	//다형성 
	public void insertMember(Member member){
		this.memberArr[memberIndex++] = member;
	}
	
	public void printData() {
		System.out.println("-----------정보출력-------------");
		System.out.printf("%-15s %-15s %-15s %-15s\n", "이름","등급","포인트","이자포인트");
		for(int i = 0; i < memberIndex; i++){
			Member member = memberArr[i];
			System.out.printf("%-15s %-15s %-15d %-15.2f\n", member.getName(), member.getGrade(), 
							  member.getPoint(), 
							  member.getEjapoint());
		}
	}
	public void printBuyInfo (int price ) {
		System.out.println("-----------------------");
		for (int i = 0 ; i < memberIndex ;  i ++ ) {
			Member member = memberArr[i];
			System.out.printf("%s등급회원 %s는 %d원 상품을 %d원에 구매합니다 \n",
					member.getGrade(),
					member.getName(),
					price,
			        member.buy(price) );
		}
	}
	
	
	
}
	

