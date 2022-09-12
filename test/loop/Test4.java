package com.sh.test.loop;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Test4 study = new Test4();
		study.test1();

	}
 
	public void test1() {
		// 문자열 입력 , 문자 검색 문자열의 길이를 리턴 String 의 메소드
		// 영문자 아니라면 false
		Scanner sc = new Scanner(System.in);
		//문자 검색은 기본 정규식표현 그리고 아스키코드로도 가능하다.
		boolean eng = false;

		System.out.println("문자열을 입력하세요");
		String str = sc.next();
		System.out.println("검색할 문자를 입력하세요.");
		char serch = sc.next().charAt(0);
		//대문자 소문자 검사      아스키코드로 검사   str.charAt(i)  i 아스키코드로 검사가능   영문자 대문자  구분한다.
		for (int i = 0; i < str.length(); i++)
			// 소문자 , 대문자가 아니라면  true 대입후   밑에서 영문자 아닙니다 라고 출력
			if (!(str.charAt(i) > 64 && str.charAt(i) < 91) && !(str.charAt(i) > 96 && str.charAt(i) < 123))
				eng = true;
			
		if (eng == true) {
			System.out.println("영문자가 아닙니다.");
			return;

		}
		int count = 0;
		//문자 갯수 검색 
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == serch) {
				count++;
			}
		}

		System.out.println("문자열 입력 : " + str);
		System.out.println("문자 입력 : " + serch);
		System.out.printf("'%s'가 포합된 갯수 : %d개", serch, count);

	}
}
