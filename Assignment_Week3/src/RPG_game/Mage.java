package RPG_game;

public class Mage extends Hero{
	public Mage(String n,int h, int a) {
		super(n,h,a);
	}
	@Override
	public void attack() {
		System.out.println("마법 화살을 발사하여 [" + this.ad + "] 만큼의 데미지를 줍니다.");
	}
	
	public void meteor() {
		System.out.println("스킬 추가 : 하늘에서 운석이 떨어집니다!");
	}
}
