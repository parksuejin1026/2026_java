package Week3;

import java.util.Scanner;
import java.util.Random;

public class Assi_3_1 {	
			
			public static void main(String[] args) {
//				1.좀비 게임을 만들어보자.
//				맵은 1~20까지이며 맵에 있는 좀비를 피해 20까지 도착하는 종료하는 게임
//				“좀비1”은 맵 위치 7 ,“좀비2”, 맵 위치 15 을 가지는 좀비를 생성하자.
//				주인공은 사용자로부터 입력을 받아  1번이 입력되면 움직이기(왼쪽), 2번이 입력되면 움직이기(오른쪽), 3번이 입력되면 점프하기(랜덤하게 오른쪽으로 1~3움직임)를 실행하도록 하자
//				내가 먼저 이동하고 좀비들은 한턴마다 랜덤하게 좌우로 1씩 움직이기 동작을 실행하도록 하자.
//				주인공의 위치와 좀비의 위치가 같아 부딪치면 “좀비에게 잡혔습니다. 처음위치에서 다시 시작합니다.” 라고 출력하세요.
//				주인공이 20에 다다르면 “미션 클리어!!! 목적지에 도착했습니다” 출력
//				매 턴마다 주인공과 좀비의 위치를 출력하세요.
				Random r = new Random();
				Scanner sc = new Scanner(System.in);
				int you = 1;
				// int zom1 = 7;
				// int zom2 = 15;
				int zoms[] = { 7, 15, 25, 34, 47}; // 좀비 5마리 위치
				
				System.out.println("==================== 좀비 게임 ====================");
				while(true) {
					System.out.print("이동하기 위해 번호를 입력해주세요. 1(왼쪽), 2(오른쪽), 3(점프 1~3) : ");
					
					int input = sc.nextInt();
					int zom_move[] = new int[5];					
					for (int i = 0; i < zoms.length ; i++) {
						zom_move[i] = r.nextInt(2);
						System.out.println(zom_move[i]);
					}
					// 유저이동
					if(input == 1) {
						if (you == 1) {
							System.out.println("사용자의 위치가 0이될수는 없습니다. 좌표 1로 돌아갑니다.");
							you = 1;
							continue;
						}
						you--;
						System.out.println("왼쪽으로 이동했습니다. 현재 위치 : " + you);
						
					}
					else if(input == 2) {
						you++;
						System.out.println("오른쪽으로 이동했습니다. 현재 위치 : " + you);
					}
					else if(input == 3) {
						you = r.nextInt(3)+1;
						System.out.println("점프했습니다. 현재 위치 : " + you);
					}
					// 좀비이동
					
					for (int i = 0 ;  i < zoms.length ; i++) {
						if(zom_move[i] == 0) {
							zoms[i]--;
							System.out.println("좀비 " + i + "가 왼쪽으로 이동했습니다 현재 위치 : " + zoms[i]);
						}
						else if(zom_move[i] == 1) {
							zoms[i]++;
							System.out.println("좀비 " + i + "가 오른쪽으로 이동했습니다 현재 위치 : " + zoms[i]);
						}
					}
					
					for (int i = 0 ; i < zoms.length ; i++) {
						if (you == zoms[i]) {
							System.out.println("좀비에게 잡혔습니다! 처음 위치로 돌아갑니다!");
							break;
						}
					}
					
					if(you >= 50) {
						System.out.println("미션 클리어! 목적지에 도착하였습니다!");
						break;
					}
					}
					
					sc.close();
					
			}

		

	}


