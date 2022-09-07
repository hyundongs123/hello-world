package com.sh.test.condition;

import java.util.Scanner;

public class Test5 {

	public static void main (String [] args) {
		Test5 study = new Test5();
		study.test1();
	}
	public void test1() {
		Scanner sc = new Scanner(System.in);
		//  !! 입력은 cm  계산m   int로 계산하면 안돼 bmi 제대로 안나옴
		System.out.println("키(cm)와 몸무게(kg)을 입력하세요.");
		double height	= sc.nextDouble();
		double weight  = sc.nextDouble();
		//계산할때 m로 환산식
		height /=100;
		
		System.out.println(height);
		System.out.println(weight);
		double bmi = weight/(height *height) ;
		// 보기쉽게 bmi값 보여준다
		if (bmi <18.5) {
			System.out.println("저체중 bmi = "+ bmi);
		}else if (bmi < 23) {
			System.out.println("정상체중 bmi =  "+ bmi);
		}else if (bmi <25) {
			System.out.println("과체중 bmi = "+ bmi);
		}else if (bmi < 30) {
			System.out.println("비만 bmi = "+ bmi);
		}else if (bmi >= 30) {
			System.out.println("고도비만 bmi = "+ bmi);
		}
	}
}
