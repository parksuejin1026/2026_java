package 인터페이스;

public class BattleManager {
	public void orderAttack(Hero hero) {
		hero.attack();
	}
	
	public void orderHeal(Hero hero) {
		if (hero instanceof healable) {
			((healable)hero).heal();
		} else {
			System.out.println(hero.name + "은 치유 능력이 존재하지 않습니다.");
		}
	}
}
