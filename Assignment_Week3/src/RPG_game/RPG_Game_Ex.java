package RPG_game;

import java.util.*;

public class RPG_Game_Ex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("어떤 직업으로 전직하시겠습니까? 1. 전사 2. 마법사");
		
		int job = sc.nextInt();
		
		if(job == 1) {
			Hero w = new Warrior("전사", 10, 1); 
			w.attack();
			((Warrior)w).bash();
		}
		else if(job == 2) {
			Hero m = new Mage("마법사", 10, 2);
			m.attack();
			((Mage)m).meteor();
		}
	}
}
