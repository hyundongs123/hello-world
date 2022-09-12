package com.sh.test.loop;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {

		Test1 study = new Test1();
		study.test1();
	}

	public void test1() {
		Scanner sc = new Scanner(System.in);

		System.out.println("정수를 입력하세요");
		int num = sc.nextInt();
		int sum = 0;

		for (int i = 1; i < num; i++) {
			sum += i;
		}

		System.out.println(sum);

	}

}
