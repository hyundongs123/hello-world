package com.sh.oop.book.model;

public class Book {

	private String title;
	private int price;
	private double discountRate;
	private String author;
	
	
	public Book() {
		
	}
	public Book(String title,int price ,double discountRate,String author) {
		this.title =title;
		this.price =price;
		this.discountRate=discountRate;
		this.author =author;
	}

	public void printBook() {
		System.out.println(title+" "+price+" "+discountRate+" "+author);
	}
	
	public void setTitle (String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice () {
		return price;
		
	}
	public void setDiscountRate (double discountRate) {
		this.discountRate =discountRate;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setAuthor(String author) {
		this.author =author;
	}
	public String getAuthor() {
		return author;
	}
	
	
}
