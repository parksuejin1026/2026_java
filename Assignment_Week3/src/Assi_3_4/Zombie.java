package Assi_3_4;

import java.util.*;

public class Zombie {
	String name;
	int curPos;
	
	public Zombie(String name, int curPos) {
		this.name = name;
		this.curPos = curPos;
	}
	
	public void move() {
		Random r = new Random();
		int num = r.nextInt(3);
		if(num == 0) {
			curPos--;
			System.out.println("왼쪽으로 이동했습니다. " + name + "좀비의 위치 : " + curPos);
		}
		else if(num == 1) {
			System.out.println("움직이지 않았습니다. " + name + "좀비의 위치 : " + curPos);
		}
		else if(num == 2) {
			System.out.println("오른쪽으로 이동했습니다. " + name + "좀비의 위치 : " + curPos);
		}
	}
}
