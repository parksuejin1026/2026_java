package Week2;

import java.util.Random;

public class Assi_2_3 {

	public static void main(String[] args) {
//		(실습과제 2-3 랜덤/연산자) 주사위 던져서 나온 숫자의 합과 평균 출력
//		주사위를 2개 던져서 나온 숫자의 합을 출력하세요.
//		그 평균도 출력하세요. 소숫점으로 나오도록 하세요.
		Random r = new Random();
		
		int dice1 = r.nextInt(6)+1; 
		int dice2 = r.nextInt(6)+1;
		int dice_Add = dice1+ dice2;
		double dice_Avg = (dice1 + dice2) / 2;
		
		System.out.println("첫 번째 주사위 눈금 : " + dice1);
		System.out.println("두 번째 주사위 눈금 : " + dice2);
		
		System.out.println("두 주사위 눈금의 합 : " + dice_Add);
		System.out.println("두 주사위 눈금의 평균 : " + dice_Avg);
	}

}
