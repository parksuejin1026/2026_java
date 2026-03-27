package Assi_3_4;

import java.util.Scanner;

public class ZombieGame {

	public static void main(String[] args) {
		Hero h = new Hero("호날두" , 1);
		Zombie z1 = new Zombie("좀비 1", 7);
		Zombie z2 = new Zombie("좀비 2", 15);
		Scanner sc = new Scanner(System.in);
		System.out.println("좀비 게임 시작!");
		while(true) {
			System.out.print("이동 방식을 선택해주세요 1.왼쪽 2.오른쪽 3.점프(1~3) : ");
			int num = sc.nextInt();
			if(num == 1) {
				h.leftMove();
				if(h.curPos <= 0) {
					System.out.println("현재 위치가 0이 될수는 없습니다. 처음 위치로 돌아갑니다.");
					h.curPos = 1;
					continue;
				}
				if(h.curPos == z1.curPos || h.curPos == z2.curPos) {
					System.out.println("좀비와 부딪혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + (--h.lifePoint) );
					if(h.lifePoint <= 0) {
						System.out.println("남은 생명이 없습니다. Gameover!!");
						break;
						}
					continue;
					}
				
				z1.move();
				z2.move();
				if(h.curPos == z1.curPos || h.curPos == z2.curPos) {
					System.out.println("좀비와 부딪혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + (--h.lifePoint));
					if(h.lifePoint <= 0) {
						System.out.println("남은 생명이 없습니다. Gameover!!");
						break;
					}
					continue;
				}
			}
			else if(num == 2) {
				h.rightMove();
				if(h.curPos == z1.curPos || h.curPos == z2.curPos) {
					System.out.println("좀비와 부딪혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + (--h.lifePoint) );
					if(h.lifePoint <= 0) {
						System.out.println("남은 생명이 없습니다. Gameover!!");
						break;
						}
					continue;
				}
				z1.move();
				z2.move();
				if(h.curPos == z1.curPos || h.curPos == z2.curPos) {
					System.out.println("좀비와 부딪혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + (--h.lifePoint));
					h.curPos = 1;
					if(h.lifePoint <= 0) {
						System.out.println("남은 생명이 없습니다. Gameover!!");
						break;
					}
					continue;
				}
				if(h.curPos >= 20) {
					System.out.println("축하합니다! 탈출에 성공하셨습니다! 남은 생명 : " + h.lifePoint );
					break;
				}
			}
				
			else if(num == 3) {
				h.jump();
				if(h.curPos == z1.curPos || h.curPos == z2.curPos) {
					System.out.println("좀비와 부딪혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + (--h.lifePoint) );
					h.curPos = 1;
					if(h.lifePoint <= 0) {
						System.out.println("남은 생명이 없습니다. Gameover!!");
						break;
						}
					continue;
					}
				
				z1.move();
				z2.move();
				if(h.curPos == z1.curPos || h.curPos == z2.curPos) {
					System.out.println("좀비와 부딪혔습니다. 처음 위치로 돌아갑니다. 남은 생명 : " + (--h.lifePoint));
					h.curPos = 1;
					if(h.lifePoint <= 0) {
						System.out.println("남은 생명이 없습니다. Gameover!!");
						break;
					}
					continue;
				}
				if(h.curPos >= 20) {
					System.out.println("축하합니다! 탈출에 성공하셨습니다! 남은 생명 : " + h.lifePoint);
				}
			}
			}
		}
	
}
