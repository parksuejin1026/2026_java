package Study;

import java.util.*;

public class Study_8 {

	public static void main(String[] args) {
		// 과제: 추가 배열을 생성하지 않고, 원본 배열의 요소 순서를 완전히 반대 순서로 뒤집으세요.
		Random r = new Random();
		
		int[] arr = new int[10]; // 배열 생성
		
		for (int i = 0 ; i < arr.length ; i++) {
			int ranNum = r.nextInt(20)+10;
			arr[i] = ranNum;
		}
		
		System.out.println("-- 현재 생성된 배열 --");
		System.out.print("총 길이 : " + arr.length + ", 요소 : ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println("-- 배열 뒤집기 --");
		
		int start = 0;
		int end = arr.length - 1;
		
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
		
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

}
