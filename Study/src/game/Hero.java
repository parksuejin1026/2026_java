package game;

import java.util.Scanner;

public class Hero extends Entity implements Attackable {
	private int ammo; // 총알 수
	private Scanner sc = new Scanner(System.in);

	public Hero(String n, int h, int c, int a) {
		super(n, h, c);
		this.ammo = a;
	}
	@Override
	public void attack(Entity target) {
		if (ammo-- > 0) {
			System.out.println("탕! " + name + "의 사격");
			target.takeDamage(20);
		}
	}

	@Override
	public void move() {
		System.out.println("이동 방향(1:왼쪽, 2:오른쪽): ");
		if (sc.nextInt() == 1) curPos--; else curPos++;
		System.out.println(name + "  위치 : " + curPos);
		}

}
