package 추상클래스2;

public class Ex {

	public static void main(String[] args) {
		BattleManager bm = new BattleManager();
		
		// 다형성 : 부모 타입 변수에 자식 객체 대입
		Hero w = new Warrior("첸슬러");
		Hero a = new Archer("레나");
		
		bm.orderAttack(w);
		bm.orderAttack(a);
		
		System.out.println("-----------------");
		
		Hero[] party = { new Warrior("엘리시스"), new Archer("진")};
		
		for (Hero p : party) {
			bm.orderAttack(p);
			
		}
	}

}
