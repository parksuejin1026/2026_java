package 추상클래스2;

abstract public class Hero {
	String name;
	
	public Hero(String name) {
		this.name = name;
	}
	
	abstract void attack();
}
