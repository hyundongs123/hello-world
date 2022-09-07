package com.sh.test.random;
import java.util.Scanner;
public class RandomTest {

	public static void main(String[] args) {

		RandomTest study = new RandomTest();
		study.test1();
	}

	public void test1() {
		// 가위바위보 게임
		Scanner sc = new Scanner(System.in);
		int coms = (int) (Math.random() * 3 + 1);

		System.out.println("===가위 바위 보 게임 ===");
		System.out.println("숫자를 선택하세요 1.가위 .2.바위 3.보");
		int users = sc.nextInt();

		System.out.println("======결과======");
		if (users == 1) {
			System.out.println("당신은 가위를 냈습니다");
		} else if (users == 2) {
			System.out.println("당신은 바위를 냈습니다");
		} else {
			System.out.println("당신은 보를 냈습니다");
		}

		if (coms == 1) {
			System.out.println("컴퓨터는 가위를 냈습니다");
		} else if ( coms == 2) {
			System.out.println("컴퓨터는 바위를 냈습니다");
		} else {
			System.out.print("컴퓨터는 보를 냈습니다\n");
		}

		System.out.println("==============");
		if (coms == users) {
			System.out.println("당신이 비겼습니다.");
			// 1가위 2바위 3보
		} else if ((coms == 1 && users == 2) || (coms == 2 && users == 3) || (coms == 3 && users == 1)) {
			System.out.println("당신이 이겼습니다.");
		} else {
			System.out.println("당신이 졌습니다.");
		}
	}

			
			
			
		}
	
