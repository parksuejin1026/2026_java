package Week3;

import java.util.*;

public class Character {
	/*
	 * 1) 격투 게임 캐릭터 클래스를 만드시오
     - 캐릭터는 이름과 체력을 가진다. (멤버 변수)
     - 캐릭터는 공격을 할 수 있다. (메소드)
     - 캐릭터 클래스는 생성자를 가진다.
	 */
	Random r = new Random();
	String name;
	int hp;
	
	public Character(String n, int h) {
		this.name = n;
		this.hp = h;
	}
	
	public void attack(int power, Character enemy) {
		int att = r.nextInt(power)+1;
		enemy.hp -= att;
		System.out.println(name + "의 공격! 위력 : " + att +" "+ enemy.name + "의 남은 체력 : " + enemy.hp);
		
	}
	
}


