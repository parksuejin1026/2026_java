package RaidGame;

import java.util.ArrayList;

public class Boss extends Unit {
	private boolean isEnraged = false; // 광폭화 여부

	public Boss(String name, int hp, int power) {
		super(name, hp, power);
	}

	@Override
	void takeDamage(int damage) {
		super.takeDamage(damage);
		// 체력이 50% 이하고 광폭화 전이라면?
		if (this.hp <= (this.maxHp * 2) && !isEnraged) { // 광폭화가 되면 true로 변환돼서 한번만 발동
			isEnraged = true;
			this.power *= 2;
			System.out.println(name + "가 광폭화하여 공격력이 2배가 됩니다!");
		}

	}

	public void wideAttack(ArrayList<Unit> party) {
		System.out.println(name + "의 광역 화염 방사!");
		for (Unit w : party) {
			w.takeDamage(this.power);
		}
	}
}
