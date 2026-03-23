package game;

public class Zombie extends Entity implements Attackable {
	public Zombie (String n, int h, int c) {
		super(n, h, c);
	}
	
	@Override
	public void attack(Entity target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		curPos += (r.nextInt(3) - 1);
		System.out.println(name + " 위치 : " + curPos);
		
	}

}
