package Study;

public class Study_7 {

	public static void main(String[] args) {
		// 빈도수 분석 및 상위 K개 추출
		int[] nums = {1, 3, 2, 3, 1, 3, 4, 1, 1}; // 배열 생성
		int k = 3; //  상위 몇 개를 뽑을지 설정
		
		// 1. 빈도 저장용 배열 생성
		int[] freq = new int[10];
		
		for (int num : nums) { // 만약 1이 나오면 1번째 인덱스의 같을 늘림
			freq[num]++;
		}
		
		System.out.println("가장 많이 등장한 상위 " + k + "개 숫자 : ");
		
		for (int i =0 ; i < k ; i++) {
			int maxFreq = -1; // 제일 높은 빈도수
			int mostFreqNum = -1; // 제일 높은 빈도수를 가진 숫자
			
			for (int j = 0 ; j < freq.length ; j++ ) { 
				if (freq[j] > maxFreq) { // 만약 빈도수 배열의 값이 제일 높은 빈도수보다 높다면
					maxFreq = freq[j]; // 최빈값
					mostFreqNum = j; // 최빈값의 숫자
				}
			}
			
			if (mostFreqNum != -1) { // 찾은 숫자를 출력하기 위한 if 문
				System.out.println("숫자 : " + mostFreqNum + " (빈도 : " + maxFreq + "회)"); // 숫자 출력
				freq[mostFreqNum] = 0; // k번을 출력해야되기 때문에 제일 높은 값의 빈도수를 0으로 설정
			}
		}
	}

}
