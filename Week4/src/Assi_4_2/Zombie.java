package Assi_4_2;

import java.util.Random;

public class Zombie extends Unit {
	public Zombie(String name, int curPos) {
		super(name);
		this.curPos = curPos;
	}
	
	private Random r = new Random();
	
	@Override
	void move() {
		int num = r.nextInt(2);
		if(num == 0) { super.left();}
		else if(num == 1) {super.right();}
	}

}
