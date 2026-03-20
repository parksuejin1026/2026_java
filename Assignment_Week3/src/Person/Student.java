package Person;

public class Student extends Person{
	public void set() {
		age = 30;
		name = "홍길동";
		height = 175;
		// weight = 99; private는 다른 클래스에서 관여 불가능
		setWeight(99);
	}
	public String toString() {
		return "Student [" + super.toString() + "]";
	}
}
