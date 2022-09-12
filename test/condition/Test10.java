package com.sh.test.condition;

import java.util.Scanner;

public class Test10 {
	
	public static void main (String [] args ) {
		Test10 study =new Test10();
		
		study.test1();
		
		
	}
	public void test1() {
		Scanner sc =new Scanner(System.in);
	
		System.out.println("점수를 입력하세요.");
		int score  =sc.nextInt();
		
		String grade = "";
		
		if (score >89 ) {
			grade = "수";
		}else if (score >79 ) {
			grade = "우";
		}else if (score >69) {
			grade = "미";
		}else if (score> 59) {
			grade ="양";
		}else {
			grade ="가";
		}
		
		System.out.printf("%d점은 %s입니다.",score,grade);
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
