package 추상클래스;

//4. 실행 메인 클래스
public class RPGGame {
 public static void main(String[] args) {
     // [핵심] 부모 타입의 배열 생성 (다형성 바구니)
     Hero[] party = new Hero[4];

     // 배열에 서로 다른 자식 객체들을 담음
     party[0] = new Warrior("아라곤", 150);
     party[1] = new Mage("간달프", 100);
     party[2] = new Warrior("기밀", 130);
     party[3] = new Archer("레나", 120);

     System.out.println("=== 전투 시작! 모든 영웅 기술 발사 ===");

     // [핵심] for문을 이용한 일괄 처리
     for (int i = 0; i < party.length; i++) {
         // 각 방에 들어있는 객체에 따라 서로 다른 specialSkill이 실행됨!
         party[i].specialSkill();
     }

     System.out.println("\n=== 몬스터의 광역 공격! ===");
     // 향상된 for문 사용 예시
     for (Hero h : party) {
         h.takeDamage(30);
     }
 }
}