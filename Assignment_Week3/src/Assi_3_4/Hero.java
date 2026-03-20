package Assi_3_4;

import java.util.*;

public class Hero {
	String name;
	int curPos;
	int lifePoint;
	
	public Hero(String name, int curPos, int lifePoint) {
		this.name = name;
		this.curPos = curPos;
		this.lifePoint = lifePoint;
	}
	
	void leftMove() {
		curPos--;
		System.out.println(name + "이 왼쪽으로 이동했습니다. 현재 위치 : " + curPos);
	}
	void rightMove() {
		curPos++;
		System.out.println(name + "이 오른쪽으로 이동했습니다. 현재 위치 : " + curPos);
	}
	void jump() {
		Random r = new Random();
		int num = r.nextInt(3)+1;
		if(num == 1) {
			curPos++;
			System.out.println(name + "이 1칸 점프했습니다. 현재 위치 : " + curPos);
		}
		else if(num == 2) {
			curPos += 2;
			System.out.println(name + "이 2칸 점프했습니다. 현재 위치 : " + curPos);
		}
		else if(num == 3) {
			curPos += 3;
			System.out.println(name + "이 3칸 점프했습니다. 현재 위치 : " + curPos);
		}
		
	}
}
