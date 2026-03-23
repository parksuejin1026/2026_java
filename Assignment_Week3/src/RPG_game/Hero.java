package RPG_game;

public class Hero {
	String name;
	int hp;
	int ad;
	
	public Hero(String n, int h, int a) {
		this.name = n;
		this.hp = h;
		this.ad = a;
	}
	public void attack() {
		System.out.println("기본 공격을 합니다.");
	}
}
