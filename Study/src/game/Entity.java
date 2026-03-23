package game;

import java.util.Random;
public abstract class Entity {
	protected String name;
	protected int hp;
	protected int curPos;
	protected static Random r = new Random();
	
	public Entity(String n, int h, int c) {
		this.name = n;
		this.hp = h;
		this.curPos = c;
	}
	
	public abstract void move() ;
	
	public void takeDamage(int damage) {
		hp -= damage; // this로 메서드를 발동시킨 객체의 체력을 감소시킴
		System.out.println(name + "가 " + damage + "피해를 입음. (남은 HP : " + hp + ")" );
	}
	
	public boolean isAlive() { return hp > 0; }
	public int getCurPos() {return curPos; }
}
