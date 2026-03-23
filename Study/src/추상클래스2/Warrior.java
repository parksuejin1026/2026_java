package 추상클래스2;

public class Warrior extends Hero{
	public Warrior(String name) { super(name);}
	
	@Override
	void attack() {
		System.out.println(name + "이(가) 검으로 베기 공격을 합니다!");
	}
}
