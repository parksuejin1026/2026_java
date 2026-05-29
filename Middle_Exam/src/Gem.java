
public class Gem {
    private String name;   
    private int number;    
    private int pos;   
    
 
    public Gem(String name, int number, int pos) {
        this.name = name;
        this.number = number;
        this.pos = pos;
    }
    
    public void getItem() {
        System.out.println(name + "을(를) 획득했습니다!");
    }
    
    public String getName() { return name; }
    public int getNumber() { return number; }
    public int getPos() { return pos; }
}