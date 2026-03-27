package Assi_4_2;

import java.util.Random;

public class ZombieKing extends Unit {
	public ZombieKing(String name,int curPos) {
		super(name);
		this.curPos = curPos;
	}
	
	private Random r = new Random();
	
	@Override
	void move() {
		int num = r.nextInt(20) + 1;
		curPos = num;
		System.out.println(name + "이 " + num + "으로 순간이동합니다!");
	}

}
