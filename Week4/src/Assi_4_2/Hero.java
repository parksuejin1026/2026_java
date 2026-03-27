package Assi_4_2;
import java.util.Scanner;
import java.util.Random;

public class Hero extends Unit {
	public Hero (String name) {
		super(name);
	}
	private Scanner sc = new Scanner(System.in);
	private Random r = new Random();
	
	@Override
	void move() {
		System.out.print("이동할 방식을 선택해주세요. 1.왼쪽 2.오른쪽 3.점프(1~3) : ");
		int num = sc.nextInt();
		if (num == 1) { super.left(); }
		else if(num == 2) {super.right();}
		else if(num == 3) {
			int ran = r.nextInt(3) + 1;
			curPos += ran;
			System.out.println(ran +"만큼 점프하였습니다. 현재 위치 : " + curPos);
		}
	}

}
