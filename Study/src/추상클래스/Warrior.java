package 추상클래스;

class Warrior extends Hero {
    public Warrior(String name, int hp) {
        super(name, hp); // 부모 생성자 호출
    }

    @Override
    public void specialSkill() {
        System.out.println("[전사 " + name + "] 파워 슬래시! 강력한 칼질을 합니다.");
    }
}