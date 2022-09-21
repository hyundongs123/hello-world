package com.sh.oop.emp.model;

import java.util.Scanner;

public class Employee {

	private int empNo;
	private String empName;
	private String dept;
	private String job;
	private int age;
	private char gender;
	private int salary;
	private double bonusPoint;
	private String phone;
	private String address;
	
	
	public void empInput(String args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("새사원정보를 입력하세요.");
		System.out.println("사번,이름,소속부서,직급을 입력하세요.(예)5238 김현동 영업 대리");
		empNo =sc.nextInt();
		setempNo(empNo);
		System.out.println("이름을 입력하세요");
		empName = sc.next();
		setempName(empName);
		System.out.println("소속부서를 입력하세요");
		dept = sc.next();
		setDept(dept);
		System.out.println("직급을 입력하세요");
		job = sc.next();
		setJob(job);
		System.out.println("나이,성별,급여,보너스포인트,핸드폰,주소를 입력하세요.");
		age = sc.nextInt();
		setAge(age);
		System.out.println("성별을 입력하세요");
		gender = sc.next().charAt(gender);
		setGender(gender);
		System.out.println("연봉을 입력하세요");
		salary =sc.nextInt();
		setSalary(salary);
		System.out.println("보너스포인트를 입력하세요");
		bonusPoint =sc.nextDouble();
		setBonusPoint(bonusPoint);
		System.out.println("핸드폰 번호를 입력하세요.");
		phone =sc.next();
		setPhone(phone);
		System.out.println("주소를 입력하세요.");
		address = sc.next();
		setAddress(address);
	}
	
	//사원 삭제 메소드
	public void ex () {
		setempNo(0);
		setempName(null);
		setDept(null);
		setJob(null);
		setAge(0);
		setGender(' ');
		setSalary(0);
		setBonusPoint(0);
		setPhone(null);
		setAddress(null);
		
		System.out.println("사원정보를 삭제하였습니다.");
	}
	public void  empOutput(){
		
	System.out.println("사번 :"+empNo);
	System.out.println("이름 : "+empName);
	System.out.println("소속부서 : "+dept);
	System.out.println("직급 : "+job);
	System.out.println("나이 : "+age);
	System.out.println("성별 : "+gender);
	System.out.println("급여 : "+salary);
	System.out.println("보너스포인트 : "+bonusPoint);
	System.out.println("핸드폰 : "+phone);
	System.out.println("주소 : "+address);
	
	
	
	
}
	public void setempNo(int empNo) {
		this.empNo= empNo;
	}
	public int getempNo() {
		return this.empNo;
	}
	public void setempName(String empName) {
		this.empName = empName;
	}
	public String getempName() {
		return this.empName;
	}
	public void setDept (String dept) {
		this.dept = dept;
	}
	public String getDept() {
		return this.dept;
	}
	public void setJob(String job) {
		this.job =job;
	}
	public String getJob() {
		return this.job;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return this.gender;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSalary() {
		return this.salary;
	}
	public void setBonusPoint (double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusPoint() {
		return this.bonusPoint;
	}
	public void setPhone (String phone) {
		this.phone = phone;
	}
	public String getPhone () {
		return this.phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress () {
		return this.address;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}