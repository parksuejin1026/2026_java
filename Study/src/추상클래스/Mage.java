package 추상클래스;

//3. 자식 클래스: Mage
class Mage extends Hero {
 public Mage(String name, int hp) {
     super(name, hp);
 }

 @Override
 public void specialSkill() {
     System.out.println("[마법사 " + name + "] 메테오! 하늘에서 운석을 떨어뜨립니다.");
 }
}
