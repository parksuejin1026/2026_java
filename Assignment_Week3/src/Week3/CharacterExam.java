package Week3;

public class CharacterExam {

	public static void main(String[] args) {
		/*
		 * 2) 다음의 캐릭터 객체를 생성하세요.
     - 이름:류, 100의 체력, 공격력 1~20의 랜덤 공격을 가지는 캐릭터
     - 이름:켄, 200의 체력,  공격력 1~10의 랜덤 공격을 가지는 캐릭터
  3) 매 턴마다 캐릭터의 체력을 출력하고 최종적으로 어떤 캐릭터가 이겼는지 출력하세요.
		 */
		Character ryu = new Character("류", 100);
		Character ken = new Character("켄", 200);
		
		while(true) {
			System.out.println(ryu.name + "의 체력 : " + ryu.hp);
			System.out.println(ken.name + "의 체력 : " + ken.hp);
			
			ryu.attack(20, ken);
			ken.attack(10, ryu);
			
			if(ken.hp <= 0) {
				System.out.println(ken.name + "의 체력이 0이하가 되었습니다. " + ryu.name + "가 승리하였습니다.");
				break;
			}
			else if(ryu.hp <= 0) {
				System.out.println(ryu.name + "의 체력이 0이하가 되었습니다. " + ken.name + "가 승리하였습니다.");
				break;
			}
			else if(ryu.hp <= 0 && ken.hp <= 0) {
				System.out.println("비겼습니다.");
			}
		}
	}

}
