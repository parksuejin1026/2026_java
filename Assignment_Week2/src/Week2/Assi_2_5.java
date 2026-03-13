package Week2;

import java.util.Scanner;
import java.util.Random;

public class Assi_2_5 {

	public static void main(String[] args) {
//		(실습과제 2-5 조건문) 좀비게임 만들기 - 내 캐릭터 움직이기
//
//	1. 주인공은 사용자로부터 입력을 받아 움직인다. 1~3 사이의 숫자를 받아 다음과 같이 움직이도록 하자. 
//	주인공의 시작위치는 1
//	1번이 입력되면 움직이기(왼쪽)이고 위치 출력 ("왼쪽으로 움직였습니다. 현재 위치는 00 입니다.")
//	2번이 입력되면 움직이기(오른쪽)이고 위치 출력 ("오른쪽으로 움직였습니다. 현재 위치는 00 입니다.")
//	3번이 입력되면 점프하기(랜덤하게 오른쪽으로 1~3움직임)를 실행하고 위치를 출력 ("점프했습니다. 현재 위치는 00 입니다.")
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int hero = 1; // 시작위치
		System.out.println("============================== 좀비 게임 ==============================");
		System.out.print("캐릭터를 움직이기 위해 번호를 선택해주세요 1(왼쪽), 2(오른쪽), 3(점프 1~3) : ");
		int num = sc.nextInt();
		if(num == 1) {
			hero--;
			System.out.println("왼쪽으로 움직였습니다. 현재 위치는 " + hero + " 입니다.");
		}else if(num == 2) {
			hero++;
			System.out.println("오른쪽으로 움직였습니다. 현재 위치는 " + hero + " 입니다.");
		}else if(num == 3) {
			int jump = r.nextInt(3)+1;
			hero += jump;
			System.out.println("점프했습니다. 현재 위치는 " + hero + " 입니다.");
		}
		System.out.println("=====================================================================");
		
		
	}

}
