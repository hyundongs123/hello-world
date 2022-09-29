package com.sh.api.member.model.vo;

import java.util.Calendar;

public class Member {

	
	private int memberNo;
	private String memberName;
	private int height;
	private int weight;
	private Calendar birth;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int memberNo, String memberName, int height, int weight, Calendar birth) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.height = height;
		this.weight = weight;
		this.birth = birth;
	}

	public String infomation() {
		
		return "1,김연아,165,47,19900905,|2,양세형,167,60,19850818|3,김래원,182,80,19810319" ;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Calendar getBirth() {
		return birth;
	}

	public void setBirth(Calendar birth) {
		this.birth = birth;
	}
	
	public String toString () {
		return "넘버 : " + memberNo + " 이름 : " + memberName + " 키 : " + height + " 몸무게 : " + weight + " 생일 "
	+ birth.get(Calendar.YEAR)+"/" + birth.get(Calendar.MONTH)+ "/"+ birth.get(Calendar.DATE) ;
	}  // Calendar 형  년  월  일 출력하기 문법
	
}
