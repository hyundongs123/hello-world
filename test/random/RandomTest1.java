package com.sh.test.random;

import java.util.Random;

public class RandomTest1 {

	public static void main(String[] args) {
		RandomTest1 study = new RandomTest1();
		study.test1();

	}

	public void test1() {
		Random rnd = new Random();
		int n = rnd.nextInt(10) + 0;
		System.out.printf("0 ~  9까지의 랜덤수 %d \n", n);
		n = rnd.nextInt(10) + 1;
		System.out.printf("1 ~ 10까지의 랜덤 수 :%d\n", n);
		n = rnd.nextInt(16) + 20;
		System.out.printf("20~35까지의 랜덤 수 :%d \n", n);
		n = rnd.nextInt(2) + 0;
		System.out.printf("0 또는 1 :%d", n);

	}

}
