package com.sh.test.condition;

import java.util.Scanner;

public class Test3 {

	public static void main (String [] args) {
		Test3 study = new Test3 () ;
		study.test();
		
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두개의 정수와 연산자를 입력하세요.입력 예 5 , 6, (+,-,*,/)");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		String sign = sc.next();
		int sum = num1 + num2 ;
		int minus = num1 - num2 ;
		int division = num1 / num2 ;
		int multiple = num1 * num2 ;
		
		
		System.out.printf("입력 %d %d %s \n",num1,num2,sign);
		if (num1 <0 || num2 <0 ){
		System.out.println("음수를 입력하샸습니다. 프로그램을 종료합니다.");
		}else if (sign.equals("+")) {
			System.out.printf("%d%s%d=%s",num1,sign,num2,sum);
		}else if(sign.equals("-")) {
			System.out.printf("%d%s%d=%s",num1,sign,num2,minus);
		}else if (sign.equals("/")) {
			System.out.printf("%d%s%d=%s",num1,sign,num2,division);
		}else if (sign.equals("*")) {
			System.out.printf("%d%s%d=%s",num1,sign,num2,multiple);
		}else {
			System.out.println("잘못된기호를 입력하셨습니다. 프로그램을 종료합니다.");
		}
			
		
		
	}
}
