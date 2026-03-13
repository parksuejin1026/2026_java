package assignment01;

import java.util.*;
public class Week2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		
		int dice1 = r.nextInt(6)+1;
		int dice2 = r.nextInt(6)+1;
		System.out.println("주사위 2개를 굴립니다.");
		System.out.println("첫 번쨰 주사위 눈 : " + dice1);
		System.out.println("두 번째 주사위 눈 : " + dice2);
		System.out.println("주사위 눈금의 합 : " + (dice1+dice2));
		
	}

}
