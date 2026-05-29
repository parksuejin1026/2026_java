import java.util.Random;

public class Human {
	private String name;  
	private int pos = 1;
    private Random r = new Random();
    
    public Human(String name) {
        this.name = name;
    }
    
    public int getPos() { return pos; } 
    public void setPos(int pos) { this.pos = pos; } 
    
    public void moveLeft() {
        if (pos > 1) { 
            pos--;
            System.out.println("왼쪽으로 이동했습니다. (현재 위치 : " + pos + ")"); 
        } else { 
            System.out.println("맵의 왼쪽 끝(1)입니다. 더 이상 나갈 수 없습니다. (현재 위치 : " + pos + ")");
        }
    }
    
    public void moveRight() {
        if (pos < 20) { 
            pos++;
            System.out.println("오른쪽으로 이동했습니다. (현재 위치 : " + pos + ")");
        } else { 
            System.out.println("맵의 오른쪽 끝(20)입니다. 더 이상 나갈 수 없습니다. (현재 위치 : " + pos + ")");
        }
    }
    
    public void jump() {
        int currentPos = this.pos; 
        pos += r.nextInt(3) + 1;
        
        if (pos <= 20) {
            System.out.println("점프를 뛰었습니다! (현재 위치 : " + pos + ")");
        } else {
            pos = currentPos;
            System.out.println("맵의 오른쪽 끝(20)으로 벗어날 수 없습니다. 이전 위치로 돌아갑니다. 현재 위치 : " + currentPos);
        }
    }
}