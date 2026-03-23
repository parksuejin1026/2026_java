package 인터페이스;

public class Ex {

	public static void main(String[] args) {
		Hero[] party = { new Archer("레나"), new Archer("레골라스") };
		BattleManager bm = new BattleManager();
		for (Hero p : party) {
			bm.orderAttack(p);
			bm.orderHeal(p);
		}
		
	}

}
