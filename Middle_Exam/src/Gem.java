// ==========================================
// [문제 1] 보물 객체를 위한 Gem 클래스 정의
// ==========================================
public class Gem {
    private String name;   // 보물 이름 (다이아, 금, 은)
    private int number;    // 보물 번호 (1, 2, 3)
    private int pos;       // 보물 위치 (1 ~ 20)
    
    // 위 멤버 변수를 초기화 시키는 생성자
    public Gem(String name, int number, int pos) {
        this.name = name;
        this.number = number;
        this.pos = pos;
    }
    
    // [요구사항] 보물 획득 시 지정된 화면 메시지 출력
    public void getItem() {
        System.out.println(name + "을(를) 획득했습니다!");
    }
    
    // Getters
    public String getName() { return name; }
    public int getNumber() { return number; }
    public int getPos() { return pos; }
}