package com.sh.test.condition;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {

		Test4 study = new Test4();
		study.test();

	}

	public void test() {
		Scanner sc = new Scanner(System.in);

		System.out.println("1~10 사이의 정수를 입력하세요");
		int num1 = sc.nextInt();

		if (num1 % 2 == 0 && (num1 > 0 && num1 <= 10)) {
			System.out.println("짝수입니다.");
		} else if (num1 % 2 == 1 && (num1 > 0 && num1 <= 10)) {
			System.out.println("홀수입니다");
		} else {
			System.out.println("반드시 1~10 사이의 정수를 입력해주세요");
		}
	}
}
