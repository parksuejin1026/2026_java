import java.util.Random;

// ==========================================
// 플레이어(인간) 클래스 (예외 및 롤백 제어 완벽 반영)
// ==========================================
public class Human {
    private int pos; // 플레이어 위치 (1 ~ 20)
    private Random r = new Random();

    public Human(int pos) {
        this.pos = pos;
    }
    
    public int getPos() { return pos; }
    public void setPos(int pos) { this.pos = pos; }
    
    public void moveLeft() {
        if (pos > 1) { 
            pos--;
            System.out.println("왼쪽으로 이동했습니다. (현재 위치 : " + pos + ")");
        } else {
            System.out.println("맵의 왼쪽 끝(1)입니다. 더 이상 나갈 수 없습니다.");
        }
    }
    
    public void moveRight() {
        if (pos < 20) {
            pos++;
            System.out.println("오른쪽으로 이동했습니다. (현재 위치 : " + pos + ")");
        } else {
            System.out.println("맵의 오른쪽 끝(20)입니다. 더 이상 나갈 수 없습니다.");
        }
    }
    
    public void jump() {
        int currentPos = this.pos; // 밖으로 튕길 때를 대비한 백업 안전장치
        pos += r.nextInt(3) + 1;    // 1 ~ 3 칸 무작위 점프
        
        if (pos <= 20) { // 20번 칸까지는 정상 착지 영역 인정
            System.out.println("점프를 뛰었습니다! (현재 위치 : " + pos + ")");
        } else {
            pos = currentPos; // 20칸 영역을 초과하여 벗어나면 이전 좌표로 강제 롤백 복원
            System.out.println("맵의 오른쪽 끝(20)으로 벗어날 수 없습니다. 이전 위치로 돌아갑니다. 현재 위치 : " + currentPos);
        }
    }
}