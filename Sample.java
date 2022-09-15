package com.sh.test.multi.dimentional.array.test;

import java.util.Random;

public class Sample {

	public static void main (String [] args) {
		Sample study = new Sample ();
//		study.exercise1();
		study.exercise2();
	}
	
	public void exercise1() {
		Random rd = new Random();
		int [][] arr = new int [3][5] ;
		
		for (int i = 0 ; i < arr.length ; i++) {
			for (int j = 0 ; j < arr[0].length ; j++) {
				int rnd = rd.nextInt(100)+1; // 난수 반복할때마다 새롭게 생성
				arr[i][j] = rnd ;
			}
		} //for문 end
		System.out.println("난수의값이 5의 배수인 행과열은 ");
		int x = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			for (int j = 0 ; j < arr[0].length ; j++) {
				 x= arr[i][j]; 		//  x에  각 행열 값을 대입 
				if(x % 5== 0 ) { 	//   배열 값이 5의 배수라면 행열 출력 
					System.out.printf("%d행 %d열 \n",i,j);
				}
			}//안쪽 for문end
		}//바깥쪽 for문 end
		
	}
	public void exercise2() {
	Random rd =new Random();
	int[][] arr= new int [3][4];
	
	
	 for (int i = 0 ; i < arr.length; i++) {
		 for (int j =0 ; j <arr[0].length-1; j++) {
			 int rnd = rd.nextInt(100)+1;
			 arr[i][j] = rnd;
		 }
	 }
	
	 for (int i = 0 ; i < arr.length ;i++ ) {
		 int [] temp = arr[i];
		temp[3] = temp[0] + temp[1] + temp[2] ;
	 }

//	 	System.out.println("0열  1열  2열  3열 ");
	 for (int i = 0 ; i< arr.length ; i++) {
		 for (int j = 0 ; j< arr[0].length; j++) {
			 
			 System.out.print(arr[i][j]+" ");
		 }
		 System.out.print("합계 \n");
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	}
		
		
		
}
