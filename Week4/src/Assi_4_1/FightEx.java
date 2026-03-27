package Assi_4_1;

import java.util.Random;

public class FightEx {

	public static void main(String[] args) {
		Character hero = new Character("호날두", 200);
		BossCharacter boss = new BossCharacter("보스", 300);
		Random r = new Random();
		while(true) {
			hero.attack(boss);
			
			int num = r.nextInt(5);
			if(num < 4) {
				boss.attack(hero);
			}
			else if (num >= 4) {
				boss.ultAttack(hero);
			}
			if(hero.hp <= 0) {
				System.out.println(hero.name +"의 체력이 0이 되었습니다. 패배하였습니다...");
				break;
			}
			else if(boss.hp <= 0) {
				System.out.println(boss.name +"의 체력이 0이 되었습니다. 승리하였습니다!");
				break;
			}
			System.out.println(hero.name + "의 남은 체력 : " + hero.hp);
			System.out.println(boss.name + "의 남은 체력 : " + boss.hp);
			
		}
	}

}
