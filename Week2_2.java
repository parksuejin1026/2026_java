package assignment01;

import java.util.Scanner;

public class Week2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력해주세요 : ");
		int age = sc.nextInt();
		
		System.out.print("생년월일을 입력해주세요 : ");
		int birth = sc.nextInt();
		
		System.out.print("키를 입력해주세요 : ");
		double height = sc.nextDouble();
		
		System.out.println("회원님의 정보를 출력하겠습니다.");
		System.out.println("========================");
		
		System.out.printf("회원님의 이름은 %s입니다.\n", name);
		System.out.printf("회원님의 나이는 %d입니다.\n", age);
		System.out.printf("회원님의 생년월일은 %d입니다.\n", birth);
		System.out.printf("회원님의 키는 %.1f입니다.\n", height);
	}

}
