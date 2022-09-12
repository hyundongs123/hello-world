package com.sh.test.loop;

import java.util.Scanner;

public class Test2 {

	public static void main (String [] args) {
		Test2 study = new Test2 ();
		study.test();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
		int num = sc.nextInt();
		for (int i = 0;  i < num ; i++) {
		if ( i % 2 == 0) {
			System.out.print("수"); 
		}
		else {
			System.out.print("박");
		}
		}
		
		
		
	}
	
}
