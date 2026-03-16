package Study;

import java.util.ArrayList;
import java.util.List;

public class Study_9 {

	public static void main(String[] args) {
		// 1. 선언 및 초기화 (인터페이스 타입인 List로 선언하는 것이 유연성에 좋음)
		List<String> techStack = new ArrayList<>();
		
		// 2. 데이터 추가 (Add)
		techStack.add("java");
		techStack.add("Python");
		techStack.add("javaScript");
		
		// 3. 데이터 접근 (Read)
		System.out.println("첫 번째 기술 : " + techStack.get(0)); // 0번째 인덱스 제거
		
		// 4. 데이터 수정 (Update)
		techStack.set(1, "Kotlin"); // Python을 Kotlin으로 변경
		
		// 5. 데이터 삭제 (Delete)
		techStack.remove(2); // 2번째 인덱스 제거
		
		System.out.println("현재 기술 스택 리스트 : ");
		for (String stack : techStack) {
			System.out.println("- " + stack);
			
		}
		System.out.println("전체 리스트 개수 : " + techStack.size());
	}

}
