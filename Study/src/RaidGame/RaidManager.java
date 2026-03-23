package RaidGame;

import java.util.ArrayList;

public class RaidManager {
	public static void main(String[] args) {
		Boss dragon = new Boss("블랙 드래곤", 500, 30);
		ArrayList<Unit> party = new ArrayList<> ();
		
		party.add(new Warrior("버서커", 200, 25));
		party.add(new Warrior("워로드", 250, 15));
		party.add(new Mage("아이샤" 400, 50));
		
		System.out.println("=== 레이드 시작 ===");
		
		while (dragon.isAlive() && !party.isEmpty()) {
			// 1. 영웅들의 턴
			for (int i = 0 ; i < party.size() ; i++) {
				Warrior w = party.get(i);
				w.useSkill(dragon); // 전원 스킬 사용
				
				if (!dragon.isAlive()) break;
			}
			
			// 2. 보스의 반격 (광역기)
			if (dragon.isAlive()) {
				dragon.wideAttack(party);
			}
			
			// 3. 사망한 파티원 제거
			for (int i = 0; i < party.size(); i++) {
				if (!party.get(i).isAlive()) {
					System.out.println(party.get(i).name + "가 전사했습니다");
					party.remove(i);
					i--; // 삭제 후 인덱스 조정
				}
			}
		}
		
		System.out.println("=== 전투 종료 ===");
		if(dragon.isAlive()) System.out.println("레이드 실패....");
		else System.out.println("축하합니다! 보스를 처지했습니다.");
	}
}
