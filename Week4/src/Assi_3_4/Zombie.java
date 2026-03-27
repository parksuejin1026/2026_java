package Assi_3_4;

import java.util.Random;
public class Zombie {
	String name;
	int curPos;
	private Random r = new Random();
	
	public Zombie(String name, int curPos) {
		this.name = name;
		this.curPos = curPos;
	}
	
	public void move() {
		int num = r.nextInt(3) - 1; // -1, 0, 1 중 하나
		if(num == -1) {
			System.out.println(name + "의 현재 위치는 " + --curPos + "입니다.");
		}
		else if(num == 0) {
			System.out.println(name + "의 현재 위치는 " + curPos + "입니다.");
		}
		else if(num == 1) {
			System.out.println(name + "의 현재 위치는 " + ++curPos + "입니다.");
		}
	}
}
