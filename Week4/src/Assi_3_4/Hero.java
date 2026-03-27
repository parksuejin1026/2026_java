package Assi_3_4;


import java.util.Random;

public class Hero {
	String name;
	int curPos;
	int lifePoint;
	private Random r = new Random();
	
	public Hero(String name, int curPos) {
		this.name = name;
		this.curPos = curPos;
		lifePoint = 3;
	}
	
	public void jump() {
		int num = r.nextInt(3) + 1;
		
		curPos += num;
		
		System.out.println(name + "이(가)" +num + "만큼 점프하였습니다. 현재 위치는 " +curPos +"입니다.");
	}
	
	public void leftMove() {
		System.out.println(name + "이(가) 왼쪽으로 이동했습니다. 현재 위치는 " + --curPos);
	}
	
	public void rightMove() {
		System.out.println(name + "이(가) 오른쪽으로 이동했습니다. 현재 위치는 "  + (++curPos));
	}
	
	
}
