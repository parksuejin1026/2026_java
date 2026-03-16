package Study;

import java.util.ArrayList;
import java.util.List;

// 1. 데이터 모델 클래스 정의
class User {
	private String name;
	private int age;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Getter 메서드
	public String getName() {return name;}
	public int getAge() {return age;}
	
	
	public  String toString() {
		return "UserName : " + name + ", UserAge : " + age;
	}
}

public class Study_10 {

	public static void main(String[] args) {
		// 2. 객체 타입을 담는 ArrayList 생성
		List<User> userList = new ArrayList<>();
		
		// 3. 데이터 삽입 (Create)
		userList.add(new User("Alice", 25));
		userList.add(new User("Bob", 30));
		userList.add(new User("Harlie", 22));
		
		// 4. 특정 조건으로 검색 (Read - Stream API 활용)
		// 25세 이상인 사용자만 필터링하여 출력
		System.out.println("--- 25세 이상 사용자 목록 ---");
		userList.stream()
				.filter(user -> user.getAge() >= 25) // getter 메서드를 활용하여 age >= 25만 필터링
				.forEach(System.out::println);
		
		// 5. 리스트 크기 확인 
		System.out.println("\n총 사용자 수 : " + userList.size());
	}

}
