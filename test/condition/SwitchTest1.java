package com.sh.test.condition;

import java.util.Scanner;

public class SwitchTest1 {

	public static void main (String [] args) {
	SwitchTest1 study = new SwitchTest1();
	study.test();
	
		
	}

	public void test() {
		Scanner sc =new Scanner(System.in);
		String menu = "----------menu----------\n"
				+"1.가정용 (50원/liter)\n"
				+"2.상업용 (45원/liter)\n"
				+"3.공업용 (30원/liter)\n"
				+"----------------------\n"
				+"메뉴번호를 선택하세요. \n"
				+"물 사용량을 입력하세요.\n";
		System.out.println(menu);
		String choice =sc.next();
		int waterliter =sc.nextInt();
		int fee = 0;
		int waterfee = 0 ;
		String type ="";
	
	//사용요금  리터당 * 사용량
	//수도세 사용요금 5%
	switch (choice) {
		case "1" :  		//가정용
			fee = 50 * waterliter ;
			type = "1.가정용 (가정집)";
			break;
		case "2" :
			fee = 45 * waterliter ;
			type = "2.상업용 (업소에서 사용하실경우)";
			break;
		case "3" : 
			fee = 40 * waterliter ;
			type = "3.공업용(공장)";
			break;
		default :
			System.out.println("메뉴번호는 1,2,3만 가능합니다.\n프로그램을종료합니다.");
			return;
	}
	
	
		waterfee = (int) ((double)fee *0.05) ;
		System.out.println("----------<<수도세>>-----------");
		System.out.printf("선택메뉴번호 : %s을 선택하셨습니다.\n",type);
		System.out.printf("사용요금 :%d\n",fee);
		System.out.printf("수도세 :%d\n",waterfee);
		System.out.printf("총수도요금 :%d\n",waterfee + fee);
	
		
	}
	
}

