package Week2;

import java.util.Scanner;
import java.util.Random;

public class Assi_2_7 {

	public static void main(String[] args) {
//		(실습과제 2-7 반복문) 격투 게임 만들기 (죽을 때까지 싸우기)
//		내 마법사는 체력이 100이고 적 전사는 체력 200으로 수정하세요.
//		"공격하려면 1을 누르세요" 라고 출력하고 1을 누르면 공격해서 적의 체력을 줄이세요.
//		내 마법사의 공격력은 15-25 사이의 랜덤 공격이고 적 전사의 공격력은 5-15 사이의 랜덤 공격이다.
//		누가 승리하였는지 출력하세요. 동시에 체력이 0 이하가 될 경우에는 비겼습니다를 출력하세요.
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int wiz = 100;
		int war = 200;
		System.out.println("==================== 격투 게임 ====================");
		while(true) {
			System.out.print("공격하려면 1을 눌러주세요. ");
			int num = sc.nextInt();
			if(num == 1) {
				int wiz_att = r.nextInt(11)+15;
				int war_att = r.nextInt(11)+5;
				wiz -= war_att;
				war -= wiz_att;
				System.out.println("내 마법사가 공격합니다. 위력 : " + wiz_att + " 적 전사 남은 체력 : " + war);
				System.out.println("적 전사가 공격합니다. 위력 : " + war_att + " 내 마법사 남은 체력 : " + wiz);
			}
			else {
				System.out.println("번호를 잘못입력하였습니다. 다시 시도해주세요.");
				continue;
			}
			if(wiz < 1) {
				System.out.println("전사가 승리하였습니다. 남은 체력 : " + war);
				break;
			}
			else if (war < 1) {
				System.out.println("마법사가 승리하였습니다. 남은 체력 : " + wiz);
				break;
			}
			else if (wiz < 1 && war <1) {
				System.out.println("동시에 체력이 0이하가 되었습니다. 비겼습니다.");
				break;
			}
			
			
		}
		System.out.println("==================================================");
	}

}
