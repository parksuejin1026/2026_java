package game;

public class RunnerZombie extends Zombie {
	public RunnerZombie (String name, int pos) { super (name, 20, pos) ;}
	
	@Override
	public void move() {
		curPos += (r.nextInt(5) - 2);
		System.out.println(name + "(러너 좀비) 위치 : " + curPos);
	}
	@Override
	public void attack(Entity target) {
		target.takeDamage(10);
	}
}
