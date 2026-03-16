package Study;

import java.util.*;

public class Study_6 {

	public static void main(String[] args) {
		// 슬라이딩 윈도우(Sliding Window) 최대 구간 합 구하기
		Random r = new Random(); 
		
		int ranArr = r.nextInt(20)+10; // 배열의 길이 랜덤으로 지정
		
		int ranNum = r.nextInt(20)+10; // 배열안에 들어갈 랜덤한 숫자
		
		int[] nums = new int[ranArr]; 
		
		
		for (int i = 0 ; i < nums.length ; i++ ) {
			nums[i] = ranNum;
		}
		
		
		int k = 3; // 구간의 크기
		
		int maxSum = 0;
		int currentWindowSum = 0;
		
		for (int i = 0 ; i < k ; i++ ) { // 첫 번째 윈도우 계산
			currentWindowSum += nums[i];
		}
		
		maxSum = currentWindowSum; // 첫 번쨰 윈도우기 때문에 무조건 최댓값
		
		for (int i = k; i < nums.length ; i++) {
			currentWindowSum += nums[i] - nums[i - k];
			
			if (currentWindowSum > maxSum) {
				maxSum = currentWindowSum;
			}
		}
		System.out.println("배열의 길이 : " + nums.length);
		System.out.println("연속된 " + k + "개의 요소의 최대 합 : " + maxSum);
		
	} 

}
