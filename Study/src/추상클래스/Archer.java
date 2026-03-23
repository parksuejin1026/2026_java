package 추상클래스;

public class Archer extends Hero{
	public Archer(String name, int hp) {
		super(name, hp);
	}
	
	public void specialSkill() {
		System.out.println("[궁수 " + name + "] 에로우 레인! 화살로 비를 내립니다.");
	}
}
