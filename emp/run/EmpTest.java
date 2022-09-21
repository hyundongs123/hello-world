package com.sh.oop.emp.run;
import java.util.Scanner;
import com.sh.oop.emp.model.Employee;

public class EmpTest {

	
	public static void main(String[] args) {
		EmpTest empTest = new EmpTest();
		Employee employee = new Employee();
		
		end:
		do {
			Scanner sc = new Scanner(System.in);
		empTest.mainMenu();
		
		int num = sc.nextInt();
		if (num ==9 ) {
			System.out.println("프로그램종료 끝내기");
			break end ;}
		
		switch (num) {
		case 1 : employee.empInput(null);
		break;
		case 2 :employee= null;
		break;
		case 3 : employee.empOutput();
		break  ;
		default : System.out.println("다시입력해주세요.");
		}
		
		}
		while (true);
		
		
	}
	
	public void mainMenu() {
		System.out.println("****** 사원 정보 관리 프로그램 *******\n");
		System.out.println("1. 사원정보 입력 \n"+
						"2. 사원 정보 삭제 \n"+
						"3. 사원정보 출력 n"
					+ "9. 끝내기\n");
		System.out.println("******************************");
		
	}
}
