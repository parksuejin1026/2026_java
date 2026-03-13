package Week2;

import java.util.Random;
import java.util.Scanner;
public class Assi_2_4 {

	public static void main(String[] args) {
//		(실습과제 2-4 입력받기) 주사위 게임 만들기
//		1. 두 사람이 주사위를 던져서 더 큰 숫자가 나오는 사람이 이기는 프로그램을 만드세요.
//		2. 이 때 먼저 던지는 사람의 이름을 입력받고 주사위 던진 결과를 출력하도록 하세요
//		(예 :   이름 : 손오공 (입력) 던진 주사위 숫자는 6
//				이름 : 저팔계 (입력) 던진 주사위 숫자는 3
//				이긴 사람은 손오공)
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int dice1 = r.nextInt(6) + 1;
		int dice2 = r.nextInt(6) + 1;
		
		System.out.println("========== 주사위 게임 ==========");
		System.out.print("이름을 입력해주세요 : " );
		String name1 = sc.nextLine();
		System.out.println("던진 주사위 눈금 : " + dice1);
		System.out.print("이름을 입력해주세요 : ");
		String name2 = sc.nextLine();
		System.out.println("던진 주사위 눈금 : " + dice2);
		
		if(dice1 > dice2) {
			System.out.println("이긴 사람은 " + name1);
		}else if (dice2 > dice1) {
			System.out.println("이긴 사람은 " + name2);
		}
		System.out.println("===============================");
		
		



	}

}
