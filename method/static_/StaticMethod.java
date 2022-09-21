package com.sh.oop.method.static_;

import java.util.regex.Pattern;

public class StaticMethod {
	
	
	static void toUpper (String str) {
		str = str.toUpperCase();
		System.out.println(str);
	}
	
	static void  setChar (String str ,int num,char ch) {
		StringBuilder  sb = new StringBuilder(str);

		sb.setCharAt(num, ch);
		str =sb.toString();
		System.out.println(str);
	}

	static void getAlphabetLength(String str) {

		int sum= 0;
		for (int i = 0 ; i<str.length() ; i++) {
			if ((str.charAt(i)>= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {	
				sum++;
			}
		}
		System.out.println(sum);
}

	static void concat (String str1 , String str2) {
		
		System.out.println(str1+str2);
		
	}







}
	
