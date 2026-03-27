package Assi_4_2;

public abstract class Unit {
	String name;
	int curPos;
	
	public Unit(String name) {
		this.name = name;
		curPos = 1;
	}
	
	public void left() {
		curPos--;
		System.out.println("왼쪽으로 1칸 움직였습니다. 현재 위치 : " + curPos);
	}
	
	public void right() {
		curPos++;
		System.out.println("오른쪽으로 1칸 움직였습니다. 현재 위치 : " + curPos);
	}
	
	abstract void move() ;
}
