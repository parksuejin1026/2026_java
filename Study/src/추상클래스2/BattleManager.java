package 추상클래스2;

public class BattleManager {
	public void orderAttack(Hero hero) {
		System.out.print("[지휘관의 명령] ");
		hero.attack();
	}
}
