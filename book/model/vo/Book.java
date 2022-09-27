package com.sh.oop.book.model.vo;

public class Book {

	private String title;
	private String author;
	private int price;
	
	public Book() {
		super();
	}

	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	
	@Override
	public String toString () {
		return "title = "+title + "author = " +author + "price = " +price ;
	}
	
	
	//복사생성자
	
	public Book (Book other ) {
		this.title = other.title;
		this.author = other.author;
		this.price = other.price;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj )
			return true;
		if (obj == null)
			return false;
		if(!(obj instanceof Book))
			return false;
		
		Book other =(Book) obj ;
		if(!this.title.equals(other.title))
			return false;
		if(!this.author.equals(other.author))
			return false;
		if(this.price != other.price)
			return false;
			
		return true;
	}
	
	
	@Override
	public Book clone () {
		return new Book(this);
	}
	
	
	
}
