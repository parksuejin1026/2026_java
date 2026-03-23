package 인터페이스;

public class Archer extends Hero implements healable{
	public Archer(String name) {
		super(name);
	}
	
	void attack() {
		System.out.println(name + "이(가) 시위를 당겨 화살을 발사합니다.");
	}
	
	public void heal() {
		System.out.println(name + "이(가) 아군을 치유합니다.");
	}
}
