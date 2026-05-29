
public class Gem {
    private String name;   
    private int number;    
    private int pos;   
    
 
    public Gem(String name, int number, int pos) {
        this.name = name;
        this.number = number;
        this.pos = pos;
    }
    
    // 보물을 획득했을 때 이름을 출력해주는 Getter 메서드
    public void getItem() {
        System.out.println(name + "을(를) 획득했습니다!");
    }
    
    // 이름, 번호, 위치 출력해주는 Getter 메서드
    public String getName() { return name; }
    public int getNumber() { return number; }
    public int getPos() { return pos; }
}