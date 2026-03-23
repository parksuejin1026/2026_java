package RPG_game;

public class Warrior extends Hero{
	public Warrior(String n, int h, int a) {
		super(n, h, a);
	}
	@Override
	public void attack() {
		System.out.println("칼을 휘둘러 [" + this.ad + "] 만큼의 데미지를 줍니다.");
	}
	
	public void bash() {
		System.out.println("방패 밀치기를 사용합니다.");
	}
}
