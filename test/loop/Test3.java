package com.sh.test.loop;

import java.util.Scanner;

public class Test3 {
public static void main (String []args) {
	
	Test3 study = new Test3();
	study.test1();
}

	public void test1() {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("연산하고싶은 단수를 입력하세요.");
	int num = sc.nextInt();
	
	
		for (int i = 1; i <10 ; i++) {
		if ( num <10 && num >0) {
		System.out.println(num+"X"+i+"=" + num*i);
		}else {System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다.");return;
		}
		}
	
	
	
}




}
