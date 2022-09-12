package com.sh.test.condition;

import java.util.Scanner;

public class Test2 {

	public static void main (String [] args) {
		
		Test2 study = new Test2();
		study.test1();
	
	}
	public void test1() {
		Scanner sc = new Scanner(System.in);
		
	System.out.println("국어 ,영어 , 수학 점수를 입력하시오 ");
	int kor = sc.nextInt();
	int eng = sc.nextInt();
	int math = sc.nextInt();

	int sum = kor + eng + math ;
	double avg = sum/3 ;

	if ((kor >=40&& eng >=40 && math >=40) && avg >= 60) {
		System.out.println("합격");
	}else {
		System.out.println("불합격");
	}
	
		
	}
	
	
	
}
