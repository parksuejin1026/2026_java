package assignment01;

import java.util.*;
import java.util.Scanner;

public class Week2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int dice1 = r.nextInt(6)+1;
		int dice2 = r.nextInt(6)+1;
		
		System.out.print("던지는 사람의 이름을 입력해주세요 : ");
		String name1 = sc.nextLine();
		System.out.print("던지는 사람의 이름을 입력해주세요 : ");
		String name2 = sc.nextLine();
		
		if (dice1 > dice2) {
			System.out.println("이긴 사람은 "+name1 + "입니다.");			
		} else if (dice1 < dice2) {
			System.out.println("이긴 사람은 " +name2 + "입니다.");
		} else {
			System.out.println("주사위의 눈금이 같습니다. 비겼습니다.");
		}
		
		
		
		sc.close();
		
	}

}
