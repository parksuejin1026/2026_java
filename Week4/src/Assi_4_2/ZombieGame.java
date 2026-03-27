package Assi_4_2;

public class ZombieGame {

	public static void main(String[] args) {
		Hero h = new Hero("호날두");
		Zombie z1 = new Zombie("좀비 1", 7);
		Zombie z2 = new Zombie("좀비 2", 15);
		ZombieKing zk = new ZombieKing("좀비킹", 20);
		
		System.out.println("좀비게임 시작!");
		while(true) {
			h.move();
			if(h.curPos <= 0) {
				System.out.println("맵 밖으로 나갔습니다. 처음 위치로 돌아갑니다.");
				h.curPos = 1;
				continue;
			}
			else if(h.curPos >= 20) {
				System.out.println("축하드립니다! 탈출에 성공하셨습니다!");
				break;
			}
			z1.move();
			z2.move();
			zk.move();
			if(h.curPos == z1.curPos || h.curPos == z2.curPos || h.curPos == zk.curPos) {
				System.out.println("좀비와 부딪혔습니다. 처음 위치로 돌아갑니다.");
				h.curPos = 1;
				continue;
			}
			
		}
		System.out.println("=====================================");
	}

	
}
