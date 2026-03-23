package 인터페이스;

abstract public class Hero {
	String name;
	
	public Hero(String name) {
		this.name = name;
	}
	
	abstract void attack();
}
