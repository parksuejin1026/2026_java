package Person;

public class Person {
	private int weight; // private 필드는 다른 클래스에서 접근이 불가능
	int age; // default 필드는 패키지내 모든 클래스 접근 가능
	protected int height; // protected는 같은 패키지 내의 모든 클래스 접근 가능
	public String name; // 다른 모든 클래스에 접근 허용
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String toString() {
		return "name =" + name + ", age = " + age + ", height = " + height + ", weight" + getWeight();
	}
}
