package com.sh.test.condition;

import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		Test9 study = new Test9();
		study.test1();

	}

	public void test1() {
		Scanner sc = new Scanner(System.in);

		String Mainmenu = "*********주메뉴*********\n" + "a. 불고기버거 ------------5000\n" + "b. 새우버거 -------------4000\n"
				+ "c. 치킨버거--------------4500\n" + "d. 한우버거-------------10000\n" + "e. 디버거--------------7000\n"
				+ "*********************** \n";
		String sidemenu = "*********사이드메뉴*********\n" + "1. 콜라 ------------1500\n" + "2. 사이다 -------------1500\n"
				+ "3. 밀크쉐이크--------------2500\n" + "4. 레드불-------------3000\n" + "***********************  \n";

		int mainprice = 0;
		int sideprice = 0;
		String mainmymenu = "";
		String sidemymenu = "";
		System.out.println(Mainmenu);
		System.out.println(sidemenu);

		String mainnum = sc.next();
		String sidenum = sc.next();

		switch(mainnum) {
		case "a":
			mainprice = 5000;
			mainmymenu = "불고기버거";
			break;
		case "b":
			mainprice = 4000;
			mainmymenu = "새우버거";
			break;
		case"c":
			mainprice = 4500;
			mainmymenu = "치킨버거";
			break;
		case"d":
			mainprice = 10000;
			mainmymenu = "한우버거";
			break;
		case"e":
			mainprice = 7000;
			mainmymenu = "디버거";
			break;
			default:
			System.out.println("번호를 잘못 누르셨습니다. 영업을 종료합니다");
			return;
		}

		switch(sidenum){
			
		case"1" :
			sideprice = 1500;
			sidemymenu = "콜라";
			break;
		case"2" :
			sideprice = 1500;
			sidemymenu = "사이다";
			break;
		case"3" :
			sideprice = 2500;
			sidemymenu = "밀크쉐이크";
			break;
		case"4" :
			sideprice = 3000;
			sidemymenu = "레드불";
			break;
		default:
			System.out.println("번호를 잘못 누르셨습니다. 영업을 종료합니다");
			return;
		}

		System.out.printf("%s,%s는 총 %d원 입니다.", mainmymenu, sidemymenu, mainprice + sideprice);

	}
}
