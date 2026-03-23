package 추상클래스2;

public class Archer extends Hero{
	public Archer(String name) {
		super(name);
	}
	
	void attack() {
		System.out.println(name + "이(가) 시위를 당겨 화살을 발사합니다.");
	}
}
