package com.sh.test.condition;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CharTest {
	public static void main (String[] args) {
		CharTest study = new CharTest();
		study.test1();
		
	}
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요.");
		String str = sc.next();
		String type = "";
		// 숫자 알파세 특수문자 한글
		if (Pattern.matches("^[a-zA-Z]*$",str)) {
			type = "알파뱃";
		}else if (Pattern.matches("^[ㄱ-ㅎ-가-힣]*$",str)){
			type = "한글";
		}else if (Pattern.matches("^[0-9]*$",str)){
			type = "숫자";
		}else  
			type = "특수문자";
		
		System.out.printf("입력하신 문자 %s는 %s입니다.",str,type);
		
		
	}
	
}
