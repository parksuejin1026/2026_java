package game;

public class NormalZombie extends Zombie {
	public NormalZombie(String name, int pos) {super (name, 30, pos) ;}
	@Override
	public void attack(Entity target) { target.takeDamage(5); }
}
