package Assi_4_1;
import java.util.Random;

public class BossCharacter extends Character {
	public BossCharacter(String name, int hp) {
		super(name, hp);
	}
	private Random r = new Random();
	
	public void attack(Character enemy) {
		int power = r.nextInt(20) + 1;
		enemy.hp -= power;
		System.out.println(enemy.name + "에게 " + power +"의 피해를 입혔습니다ㅣ.");
	}
	
	public void ultAttack(Character enemy) {
			System.out.println("20% 확률로 필살기 발동!!");
			enemy.hp -= 20;
			System.out.println(enemy.name + "에게 20의 피해를 입혔습니다.");
		
	}

}
