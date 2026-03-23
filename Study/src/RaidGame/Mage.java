package RaidGame;

public class Mage extends Unit implements SkillUsable {
    public Mage(String name, int hp, int power) {
        super(name, hp, power);
    }

    @Override
    public void useSkill(Unit target) {
        System.out.println(name + "의 화염구! 보스에게 큰 피해를 입힙니다!");
        target.takeDamage(this.power * 3);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }
}
