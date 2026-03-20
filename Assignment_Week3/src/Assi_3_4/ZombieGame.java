package Assi_3_4;

import java.util.*;
public class ZombieGame {

	public static void main(String[] args) {
		Zombie z1 = new Zombie("좀비 1", 7);
		Zombie z2 = new Zombie("좀비 2", 15);
		Hero you = new Hero("민주", 1, 3);
		System.out.println(you.lifePoint);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("이동할 방식을 입력해주세요. 1(왼쪽), 2(오른쪽), 3(점프 1~3) : ");
			
			int num = sc.nextInt();
			
			if(num == 1) { // 왼쪽 이동 입력
				you.leftMove(); // 왼쪽으로 이동하는 메서드 
				if(you.curPos <= 0) { // 만약 주인공의 현재 위치가 0이하가 된다면
					System.out.println("현재 위치가 1보다 작아질 수 없습니다. 되돌아갑니다."); // 되돌아가기
					you.curPos = 1; // 1로 변경
					continue; // continue 사용으로 while문 다시 돌기
				}
				if(you.curPos == z1.curPos || you.curPos == z2.curPos) { // 만약 이동했을 때 위치가 z1, z2와 같다면
					System.out.println("좀비에게 잡혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + (--you.lifePoint)); // 생명 횟수를 하나 줄이고 처음 위치로
					you.curPos = 1;
					if (you.lifePoint <= 0) {
						System.out.println("GameOver!!!");
						break;
					}
					continue;
				}
				z1.move();
				z2.move();
				if(you.curPos == z1.curPos || you.curPos == z2.curPos) { // 만약 이동했을 때 위치가 z1, z2와 같다면
					System.out.println("좀비에게 잡혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + (--you.lifePoint)); // 생명 횟수를 하나 줄이고 처음 위치로
					you.curPos = 1;
					if (you.lifePoint <= 0) {
						System.out.println("GameOver!!!");
						break;
					}
					continue;
				}
				
			}
			else if (num == 2) {
				you.rightMove(); // 오른쪽으로 이동
				if(you.curPos == z1.curPos || you.curPos == z2.curPos) { // 만약 z1, z2와의 위치가 같아진다면
					System.out.println("좀비에게 잡혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + --you.lifePoint); // 잡혀서 생명 포인트 감소
					you.curPos = 1;
					if (you.lifePoint <= 0) {
						System.out.println("GameOver!!!");
						break;
					}
					continue;
				}
				z1.move();
				z2.move();
				if(you.curPos == z1.curPos || you.curPos == z2.curPos) { // 만약 z1, z2와의 위치가 같아진다면
					System.out.println("좀비에게 잡혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + --you.lifePoint); // 잡혀서 생명 포인트 감소
					you.curPos = 1;
					if (you.lifePoint <= 0) {
						System.out.println("GameOver!!!");
						break;
					}
					continue;
				}
				if (you.curPos >= 20) {
					System.out.println("미션 클리어!!! 목적지에 도착했습니다");
					break;
				}
			}
			else if (num == 3) {
				you.jump();
				if(you.curPos == z1.curPos || you.curPos == z2.curPos) { // 만약 z1, z2와의 위치가 같아진다면
					System.out.println("좀비에게 잡혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + --you.lifePoint); // 잡혀서 생명 포인트 감소
					you.curPos = 1;
					if (you.lifePoint <= 0) {
						System.out.println("GameOver!!!");
						break;
					}
					continue;
				}
				z1.move();
				z2.move();
				if(you.curPos == z1.curPos || you.curPos == z2.curPos) { // 만약 z1, z2와의 위치가 같아진다면
					System.out.println("좀비에게 잡혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + --you.lifePoint); // 잡혀서 생명 포인트 감소
					you.curPos = 1;
					if (you.lifePoint <= 0) {
						System.out.println("GameOver!!!");
						break;
					}
					continue;
					
				}
				if (you.curPos >= 20) {
					System.out.println("미션 클리어!!! 목적지에 도착했습니다");
					break;
				}
			}
			
		}
		System.out.println("남은 생명 : " + you.lifePoint);
		
	}

}
