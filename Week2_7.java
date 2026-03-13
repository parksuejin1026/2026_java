package assignment01;

import java.util.Scanner;
import java.util.Random;

public class Week2_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		(실습과제 2-7 반복문) 격투 게임 만들기 (죽을 때까지 싸우기)
//		내 마법사는 체력이 100이고 적 전사는 체력 200으로 수정하세요.
//		"공격하려면 1을 누르세요" 라고 출력하고 1을 누르면 공격해서 적의 체력을 줄이세요.
//		내 마법사의 공격력은 15-25 사이의 랜덤 공격이고 적 전사의 공격력은 5-15 사이의 랜덤 공격이다.
//		누가 승리하였는지 출력하세요. 동시에 체력이 0 이하가 될 경우에는 비겼습니다를 출력하세요.
		int wizard = 100;
		int warrior = 200;
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		
		System.out.println("내 마법사의 체력 : "+ wizard);
		System.out.println("적 전사의 체력 : " + warrior);
		while(true) {
			System.out.println("공격하려면 1을 누르세요. ");
			int attack = sc.nextInt();
		
			if(attack == 1) {
				int wiA = r.nextInt(11)+15;
				int waA = r.nextInt(11)+5;
				wizard -= waA;
				warrior -= wiA;
				System.out.println("내 마법사가 공격합니다. 데미지 : " + wiA + "적 전사의 남은 체력 : "+ warrior);
				System.out.println("적 전사가 공격합니다. 데미지 : " +waA + "내 마법사의 남은 체력 : " + wizard);
				}
			
			if(wizard < 0 && warrior < 0) {
				System.out.println("동시에 체력이 0이 되어 비겼습니다.");
				break;
			}
			if(wizard > 0 && warrior < 0 ) {
				System.out.println("내 마법사가 승리했습니다! 남은 체력 : " + wizard);
				break;
			}
			if(wizard < 0 && warrior > 0) {
				System.out.println("적 전사가 승리했습니다! 남은 체력 : " + warrior);
				break;
			}
			
		}
	}

}
