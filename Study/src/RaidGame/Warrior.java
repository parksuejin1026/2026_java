package RaidGame;

public class Warrior extends Unit implements SkillUsable {
	public Warrior (String name, int hp, int power) {
		super(name, hp, power);
	}
	
	@Override
	public void useSkill(Unit target) {
		System.out.println(name + "의 강격! 보스에게 큰 피해를 입힙니다.");
		target.takeDamage(this.power * 2);
	}
	
	@Override
	public void takeDamage(int damage) {
		int reducedDamage = (int) (damage * 0.8);
		super.takeDamage(reducedDamage);
	}
}
