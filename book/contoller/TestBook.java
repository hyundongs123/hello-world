package com.sh.oop.book.contoller;

import com.sh.oop.book.model.vo.Book;

public class TestBook {

	
	public static void main(String[] args) {
		
		Book b1 = new Book("자바","홍길동",1500);
		Book b2 = new Book("자바","홍길동",1500);
		
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(b1.equals(b2));
		System.out.println();
		System.out.println(b1.hashCode()==b2.hashCode());
		}
}
