package assignment01;

import java.util.Scanner;
import java.util.Random;

public class Week2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		
		while(true) {
			int hero = 1;
			System.out.println("주인공의 현재위치는 : " + hero);
			
			System.out.print("이동 유형을 선택하세요(1.오른쪽, 2.왼쪽, 3.점프) : ");
			
			int move = sc.nextInt();
			
			if(move == 1) {
				hero--;
				System.out.println("왼쪽으로 이동했습니다. 현재 위치는 " + hero + "입니다.");
			}
			else if(move == 2) {
				hero++;
				System.out.println("오른쪽으로 이동했습니다. 현재 위치는 " + hero + "입니다.");
			}
			else if(move == 3) {
				int ranInt = r.nextInt(3)+1;
				System.out.println("점프했습니다. 현재 위치는 "+ (hero + ranInt) + "입니다.");
				}
			break;
			}
			
		
		}

	}

