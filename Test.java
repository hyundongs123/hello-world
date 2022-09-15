package com.sh.test.array.sort;

import java.util.Arrays;
import java.util.Random;

public class Test {

	public static void main (String [] args) {
		Test study = new Test();
		study.test();
		
	}
	public  void test () {
		Random rnd = new Random();
		int[] num = new int [10];
		for (int i = 0 ; i< num.length; i++) {
			int rn = rnd.nextInt(100)+1;
			num[i]= rn;
		}
	
		
		for (int i =0 ; i < num.length-1;i++) {
			int min = i;
			for (int j = i+1 ; j < num.length ; j++) {
				if (num[min] > num[j]) 
					min = j;
				
			}
			swap(num,i,min);
		}//for문 end
		
		System.out.println("최종결과 : "+ Arrays.toString(num));
		
	}// method문 end
	
	
	public void swap (int[] sw ,int i ,int j) {
		int temp = sw[i];
		sw[i] = sw[j];
		sw[j] = temp;
		
	
	}
	
}
