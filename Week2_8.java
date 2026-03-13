package assignment01;

import java.util.*;

public class Week2_8 {
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1.좀비 게임을 만들어보자.
//		맵은 1~20까지이며 맵에 있는 좀비를 피해 20까지 도착하는 종료하는 게임
//		“좀비1”은 맵 위치 7 ,“좀비2”, 맵 위치 15 을 가지는 좀비를 생성하자.
//		주인공은 사용자로부터 입력을 받아  1번이 입력되면 움직이기(왼쪽), 2번이 입력되면 움직이기(오른쪽), 3번이 입력되면 점프하기(랜덤하게 오른쪽으로 1~3움직임)를 실행하도록 하자
//		내가 먼저 이동하고 좀비들은 한턴마다 랜덤하게 좌우로 1씩 움직이기 동작을 실행하도록 하자.
//		주인공의 위치와 좀비의 위치가 같아 부딪치면 “좀비에게 잡혔습니다. 처음위치에서 다시 시작합니다.” 라고 출력하세요.
//		주인공이 20에 다다르면 “미션 클리어!!! 목적지에 도착했습니다” 출력
//		매 턴마다 주인공과 좀비의 위치를 출력하세요.
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int pla = 1;
		int zom1 = 7;
		int zom2 = 15;
		while(true) {
			int num; // 입력하는 숫자
			int jump;
			int zom1R;
			int zom2R;
			
			System.out.print("이동 방법을 선택해주세요. 1(왼쪽), 2(오른쪽), 3(점프) : ");
			num = sc.nextInt();
			
			zom1R = r.nextInt(2);
			zom2R = r.nextInt(2);
			
			if(zom1R == 1) {
				zom1--;
			}
			if(zom1R == 0) {
				zom1++;
			}
			
			if(zom2R == 1) {
				zom2--;
			}
			
			if(zom2R ==0) {
				zom2++;
			}
			
			if(num == 1) {
				pla--;
				if(pla > 20 || pla < 1) {
					System.out.println("맵을 벗어났습니다. 처음 위치에서 시작합니다.");
					pla = 1;
					}
				System.out.println("플레이어 현재 위치 : "+pla);
			}
			if(num == 2) {
				pla++;
				System.out.println("플레이어 현재 위치 : " + pla);
			}
			if(num == 3) {
				jump = r.nextInt(3)+1;
				pla += jump;
				System.out.println("플레이어 현재 위치 : " + pla);
			}
			
			if(zom1 == pla || zom2 == pla) {
				System.out.println("좀비에게 잡혔습니다. 처음 위치에서 다시 시작합니다.");
				pla = 1;
			}
			if(pla >= 20) {
				System.out.println("미션 클리어!! 목적지에 도착했습니다.");
				break;
			}
			
			
			
			
			
				
				
			
		
		
			}
		}
	
	}
