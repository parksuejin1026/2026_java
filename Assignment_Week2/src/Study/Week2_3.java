package Study;

import java.util.Random;

public class Week2_3 {

	public static void main(String[] args) {
		// 정규화된 배열의 중복 원소 제거
		int[] nums = {1, 1, 2, 2,  3, 4, 4, 5} ; // 배열 생성 
		int insertPos =  0; // 고유한 값이 들어갈 위치를 가리키는 인덱스 (0번은 절대로 겹칠 수 없음)
		
		for (int i = 1 ; i < nums.length ; i++) { // 그렇기 떄문에 i = 1부터 시작
			if (nums[i] != nums[insertPos]) {
				insertPos++;
				
				nums[insertPos] = nums[i];
				}
		}

		
		int uniqueCount = insertPos + 1; // insertPos는 인덱스 개념이라 +1
		System.out.println("중복 제거 후 남은 개수 : " + (uniqueCount));
		
		System.out.println("중복 제거 된 후 배열 옮기기");
		int[] newNums = new int[uniqueCount];
		System.out.println(uniqueCount + "개의 인덱스가 있는 새로운 배열 생성 완료!!");
		for (int i = 0; i < uniqueCount ; i++) {
			newNums[i] = nums[i];
			
			System.out.print(newNums[i] + " ");
		}
		
		}

	}



