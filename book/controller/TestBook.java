package com.sh.oop.book.controller;
import com.sh.oop.book.model.Book;


public class TestBook {
	public static void main(String[] args) {
		Book b = new Book();
		Book b1 = new Book("뇌를 자극하는 JAVA",20000,0.2,"김윤영");
		
		b.printBook();
		b1.printBook();
		b.setTitle("자바의정석");
		b.setPrice(35000);
		b.setDiscountRate(0.1);
		b.setAuthor("윤상섭");
		b.printBook();
		
		
		int  price2 = b.getPrice();
		double discountRate2 = b.getDiscountRate();
		double sum2 = price2 - (price2 *discountRate2);
		int sum3 = b1.getPrice() - (b1.getPrice() *(int) b1.getDiscountRate());
		
		System.out.println();	
		
		
	
		System.out.printf("도서명: %s\n할인된가격 : %d\n도서명 : %s\n할인된 가격 : %d",b.getTitle(),(int)sum2,b1.getTitle(),(int)sum3);
		
		
		
	}
	
}
