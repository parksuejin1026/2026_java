package Assi_4_1;

import java.util.Random;

public class Character {
 /*
  * 1)격투 게임 캐릭터 클래스를 만드시오
	•캐릭터는 이름과 체력을 가진다. (멤버 변수)
	•캐릭터는 공격 행위를 할 수 있다. (메소드)
	•캐릭터 클래스는 생성자를 가진다.
  */
	
	String name;
	int hp;
	private Random r = new Random();
	
	public Character(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}
	
	public void attack(Character enemy) {
		int power =  r.nextInt(15) + 1;
		enemy.hp -= power;
		System.out.println(enemy.name + "에게 " + power +"의 피해를 입혔습니다ㅣ.");
	}
}
