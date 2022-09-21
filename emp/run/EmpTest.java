package com.sh.oop.emp.run;

import java.util.Scanner;

import com.sh.oop.emp.model.Employee;

public class EmpTest {
	// 여러메소드에서 사용할 수 있도록 멤버변수로 선언
//	Scanner sc = new Scanner(System.in);
//	Employee e = null;

	public static void main(String[] args) {
		EmpTest t = new EmpTest();
		t.mainMenu();

	}

	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		Employee e = null; // 참조형변수 기본값
		
		String menu = "******* 사원 정보 관리 프로그램 **********\n" 
					+ "1. 새 사원 정보 입력\n" 
					+ "2. 사원 정보 수정\n" 
					+ "3. 사원 정보 삭제\n" 
					+ "4. 사원정보 출력\n"
					+ "9. 끝내기\n" 
					+ "*************************************\n" 
					+ "선택하세요 =>";

		int selected = 0;
		asd:
		while (true) {
			System.out.print(menu);
			selected = sc.nextInt();
			switch (selected) {
			case 1:
				e = new Employee();
				e.empInput();
				break;
			case 2:
				modifyMenu(e);
				break;
				
			case 3:
				// 사원정보삭제는 참조주소값을 삭제한다.
				// 실제 heap영역의 객체 삭제는 garbage collector가 담당.
				e = null;
				break;
			case 4:
				// 사원정보 미입력시 출력하지 않도록함.
				// NullPointerException 유발
				if (e == null) 
					System.out.println(">>먼저 사원정보를 입력하세요.");
				else 					
					e.empOutput();
				break;
			}
			if (selected == 9)
				break;
		}

	}
	
	public void modifyMenu(Employee e) {
		String menu = "********** 사원 정보 수정 메뉴 **********\r\n"
					+ "1. 이름 변경 => setEmpName()\r\n"
					+ "2. 급여 변경 => setSalary()\r\n"
					+ "3. 부서 변경 => setDept()\r\n"
					+ "4. 직급 변경 => setJob()\r\n"
					+ "5. 이전 메뉴로 이동 => return 처리할 것";
		
		while(true) {
			System.out.println(menu);
			Scanner sc = new Scanner(System.in);
			String num = sc.next();
			
			switch (num){
			case "1" :
				System.out.print("이름을 변경해주세요 : ");
				String name = sc.next();
				e.setEmpName(name);
				break;
			
			case "2" :
				System.out.print("급여를 변경해주세요 : ");
				int salary = sc.nextInt();
				e.setSalary(salary);
				break;
			case "3" :
				System.out.print("부서를 변경해주세요 : ");
				String dept = sc.next();
				e.setDept(dept);
				break;
			case "4" :
				System.out.print("지급을 변경해주세요 : ");
				String job = sc.next();
				e.setJob(job);
				break;
			case "5":
			return ;
			
			default : System.out.println("다시입력하세요");
								
			}//swtich문 end
				
  }

}
}
	
	
	
	
	
	









	
	