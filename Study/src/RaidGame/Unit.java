package RaidGame;

public abstract class Unit {
	String name;
	int hp;
	int maxHp;
	int power;
	
	public Unit (String name, int hp,int power) {
		this.name = name;
		this.hp = hp;
		this.maxHp = hp;
		this.power = power;
	}
	
	void takeDamage(int damage) {
		this.hp -= damage;
		if (this.hp < 0) this.hp = 0;
		System.out.println(name + "가 " + damage + "의 피해를 입음. 남은 HP: " + hp + "/" + maxHp + ")");
	}
	
	public boolean isAlive() {
		return this.hp > 0;
	}
}
