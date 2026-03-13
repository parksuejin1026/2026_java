package Week2;

import java.util.Scanner;
import java.util.Random;

public class Assi_2_6 {

	public static void main(String[] args) {
//		(실습과제 2-6 조건문/반복문) 컴퓨터와 하는 가위바위보 게임을 만드세요.
//
//		1. 사용자로부터 가위(1), 바위(2), 보(3) 입력을 받으세요.
//		2. 컴퓨터는 랜덤으로 가위(1), 바위(2), 보(3)를 선택하도록 하세요.
//		3. 사용자의 입력과 컴퓨터의 랜덤 수를 비교하여 누가 이겼는지 출력하세요.
//		4. "나는 가위, 컴퓨터는 바위를 냈습니다. 컴퓨터가 이겼습니다." 출력
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("=============== 가위바위보 게임 ===============");
		System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력해주세요. : ");
		int you = sc.nextInt();
		System.out.println("컴퓨터가 랜덤으로 선택합니다...");
		int com = r.nextInt(3)+1;
		
		if(you == 1) {
			if(com == 1) {
				System.out.println("나는 가위, 컴퓨터는 가위를 냈습니다. 비겼습니다.");
			}
			else if(com == 2) {
				System.out.println("나는 가위, 컴퓨터는 바위를 냈습니다. 졌습니다.");
			}
			else if(com == 3) {
				System.out.println("나는 가위, 컴퓨터는 보를 냈습니다. 이겼습니다.");
			}
		}
		if(you == 2) {
			if(com == 1) {
				System.out.println("나는 바위, 컴퓨터는 가위를 냈습니다. 이겼습니다.");
			}
			else if(com == 2) {
				System.out.println("나는 바위, 컴퓨터는 바위를 냈습니다. 비겼습니다.");
			}
			else if(com == 3) {
				System.out.println("나는 바위, 컴퓨터는 보를 냈습니다. 졌습니다.");
			}
		}
		if(you == 3) {
			if(com == 1) {
				System.out.println("나는 보, 컴퓨터는 가위를 냈습니다. 졌습니다.");
			}
			else if(com == 2) {
				System.out.println("나는 보, 컴퓨터는 바위를 냈습니다. 이겼습니다.");
			}
			else if(com == 3) {
				System.out.println("나는 보, 컴퓨터는 보를 냈습니다. 비겼습니다.");
				}
			}
		
		System.out.println("============================================");
		}
		
	}


