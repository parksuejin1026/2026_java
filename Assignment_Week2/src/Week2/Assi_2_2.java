package Week2;

import java.util.Scanner;
public class Assi_2_2 {

	public static void main(String[] args) {
//		(실습과제 2-2 입력받기) 키보드로부터 입력받기
//		1. 회원가입을 위해 위 항목을 입력받는 프로그램을 작성하세요.
//
//		이름(문자열)
//		나이(정수형)
//		생년월일 8자리(정수형)
//		키(실수형)
//		입력을 모두 받으면 입력받은 내용을 화면에 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("=================================");
		System.out.println("회원가입을 위해 회원정보를 입력받겠습니다.");
		System.out.println("=================================");
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.next();
		System.out.print("나이를 입력해주세요 : ");
		int age = sc.nextInt();
		System.out.print("생년월일을 입력해주세요 : ");
		int birth_Ymd = sc.nextInt(); 
		System.out.print("키(CM)를 입력해주세요 : ");
		double height = sc.nextDouble();
		System.out.printf("회원 이름 : %s, 나이 : %d, 생년월일 : %d, 키 : %.1f", name, age, birth_Ymd, height);
		
		sc.close();
	}

}
