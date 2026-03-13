package Week2;

import java.util.Scanner;
import java.util.Random;

public class Assi_2_8 {
	private static final int STAGE_MIN = 1;
	private static final int STAGE_MAX = 20;
	
	public static void main(String[] args) {
//		1.좀비 게임을 만들어보자.
//		맵은 1~20까지이며 맵에 있는 좀비를 피해 20까지 도착하는 종료하는 게임
//		“좀비1”은 맵 위치 7 ,“좀비2”, 맵 위치 15 을 가지는 좀비를 생성하자.
//		주인공은 사용자로부터 입력을 받아  1번이 입력되면 움직이기(왼쪽), 2번이 입력되면 움직이기(오른쪽), 3번이 입력되면 점프하기(랜덤하게 오른쪽으로 1~3움직임)를 실행하도록 하자
//		내가 먼저 이동하고 좀비들은 한턴마다 랜덤하게 좌우로 1씩 움직이기 동작을 실행하도록 하자.
//		주인공의 위치와 좀비의 위치가 같아 부딪치면 “좀비에게 잡혔습니다. 처음위치에서 다시 시작합니다.” 라고 출력하세요.
//		주인공이 20에 다다르면 “미션 클리어!!! 목적지에 도착했습니다” 출력
//		매 턴마다 주인공과 좀비의 위치를 출력하세요.
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int you = 1;
		int zom1 = 7;
		int zom2 = 15;
		
		System.out.println("==================== 좀비 게임 ====================");
		while(true) {
			System.out.print("이동하기 위해 번호를 입력해주세요. 1(왼쪽), 2(오른쪽), 3(점프 1~3) : ");
			int num = sc.nextInt();
			int zom1_num = r.nextInt(2);
			int zom2_num = r.nextInt(2);
			if (num == 1) {
				you--;
				System.out.println("왼쪽으로 이동합니다. 현재 위치 : " + you);
				if (you < STAGE_MIN) {
					System.out.println("위치가 1미만이 될수는 없습니다. 위치 1로 돌아갑니다.");
					you = 1;
					continue;
				}
				if(zom1_num == 0) {
					System.out.println("좀비 1이 왼쪽으로 이동합니다. 현재 위치 : " + zom1--);
				}
				else if(zom1_num == 1) {
					System.out.println("좀비 1이 오른쪽으로 이동합니다. 현재 위치 : " + zom1++);
				}
				if(zom2_num == 0) {
					System.out.println("좀비 2가 왼쪽으로 이동합니다. 현재 위치 : " + zom1--);
				}
				else if(zom2_num == 1) {
					System.out.println("좀비 2가 오른쪽으로 이동합니다. 현재 위치 : " + zom1++);
				}
				if (you == zom1 || you == zom2) {
					System.out.println("좀비에게 잡혔습니다! 처음 위치에서 다시 시작합니다!");
					you = 1;
					continue;
				}
				
			}
			if (num == 2) {
				you++;
				System.out.println("오른쪽으로 이동합니다. 현재 위치 : " + you);
				if (you < STAGE_MIN) {
					System.out.println("위치가 1미만이 될수는 없습니다. 위치 1로 돌아갑니다.");
					you = 1;
					continue;
				}
				if(zom1_num == 0) {
					System.out.println("좀비 1이 왼쪽으로 이동합니다. 현재 위치 : " + zom1--);
				}
				else if(zom1_num == 1) {
					System.out.println("좀비 1이 오른쪽으로 이동합니다. 현재 위치 : " + zom1++);
				}
				if(zom2_num == 0) {
					System.out.println("좀비 2가 왼쪽으로 이동합니다. 현재 위치 : " + zom1--);
				}
				else if(zom2_num == 1) {
					System.out.println("좀비 2가 오른쪽으로 이동합니다. 현재 위치 : " + zom1++);
				}
				if (you == zom1 || you == zom2) {
					System.out.println("좀비에게 잡혔습니다! 처음 위치에서 다시 시작합니다!");
					you = 1;
					continue;
				}
				if (you > STAGE_MAX) {
					System.out.println("미션 클리어!! 탈출에 성공하였습니다!");
					break;
				}
			}
			if (num == 3) {
				int jump = r.nextInt(3) + 1;
				you += jump;
				System.out.println("점프합니다. 현재 위치 : " + you);
				if (you < STAGE_MIN) {
					System.out.println("위치가 1미만이 될수는 없습니다. 위치 1로 돌아갑니다.");
					you = 1;
					continue;
				}
				if(zom1_num == 0) {
					System.out.println("좀비 1이 왼쪽으로 이동합니다. 현재 위치 : " + zom1--);
				}
				else if(zom1_num == 1) {
					System.out.println("좀비 1이 오른쪽으로 이동합니다. 현재 위치 : " + zom1++);
				}
				if(zom2_num == 0) {
					System.out.println("좀비 2가 왼쪽으로 이동합니다. 현재 위치 : " + zom1--);
				}
				else if(zom2_num == 1) {
					System.out.println("좀비 2가 오른쪽으로 이동합니다. 현재 위치 : " + zom1++);
				}
				if (you == zom1 || you == zom2) {
					System.out.println("좀비에게 잡혔습니다! 처음 위치에서 다시 시작합니다!");
					you = 1;
					continue;
				}
				if (you > STAGE_MAX) {
					
					System.out.println("미션 클리어!! 탈출에 성공하였습니다!");
					break;
				}
			}
		}
		
		System.out.println("=======================================================");
	}

}
