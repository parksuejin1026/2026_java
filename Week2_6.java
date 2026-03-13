package assignment01;

import java.util.Scanner;
import java.util.Random;
public class Week2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.print("가위(1) 바위(2) 보(3) 중 하나를 입력해주세요.");
		int yourNum = sc.nextInt();
		
		int com = r.nextInt(3)+1;
		
		
		if(yourNum == 1) {
			if(com == 1) {
				System.out.println("나는 가위, 컴퓨터는 가위를 냈습니다. 비겼습니다.");
			}else if (com == 2) {
				System.out.println("나는 가위, 컴퓨터는 바위를 냈습니다. 컴퓨터가 이겼습니다.");
			}else {
				System.out.println("나는 가위, 컴퓨터는 보를 냈습니다. 이겼습니다");
			}
		}
			
		else if(yourNum == 2) {
			if(com == 1) {
				System.out.println("나는 바위, 컴퓨터는 가위를 냈습니다. 이겼습니다.");
			}else if (com == 2) {
				System.out.println("나는 바위, 컴퓨터는 바위를 냈습니다. 비겼습니다.");
			}else {
				System.out.println("나는 바위, 컴퓨터는 보를 냈습니다. 컴퓨터가 이겼습니다");
			}
		}
			
		else if(yourNum == 3) {
			if(com == 1) {
				System.out.println("나는 보, 컴퓨터는 가위를 냈습니다. 컴퓨터가 이겼습니다.");
			}else if (com == 2) {
				System.out.println("나는 보, 컴퓨터는 바위를 냈습니다. 이겼습니다.");
			}else {
				System.out.println("나는 보, 컴퓨터는 보를 냈습니다. 비겼습니다.");
			}
			
		}
		}
	

		
	}
