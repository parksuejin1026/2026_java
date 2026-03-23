package 추상클래스;
// 1. 추상 클래스 (미완성 설계도 - new Hero() 불가)
abstract class Hero {
    protected String name;
    protected int hp;

    // 부모 생성자
    public Hero(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    // 추상 메서드 (자식이 반드시 구현해야 함)
    public abstract void specialSkill();

    // 일반 메서드 (자식들이 공통으로 사용)
    public void takeDamage(int damage) {
        this.hp -= damage;
        System.out.println(name + "이(가) " + damage + "의 데미지를 입었습니다. (남은 HP: " + hp + ")");
    }
}



