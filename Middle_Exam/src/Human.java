import java.util.Random;

public class Human {
	private String name; // 플레이어 이름
    private int pos = 1; // 플레이어 위치 (1 ~ 20)
    private Random r = new Random(); // 점프할 때 쓰기 위한 랜덤 객체
    
    public Human(String name) { // Human 클래스 생성자 이름을 지정하기 위해 사용
        this.name = name;
    }
    
    public int getPos() { return pos; } // 위치 반환
    public void setPos(int pos) { this.pos = pos; } // 위치 설정
    
    public void moveLeft() {
        if (pos > 1) { // 플레이어 위치가 1을 넘어선 다면 발동
            pos--;
            System.out.println("왼쪽으로 이동했습니다. (현재 위치 : " + pos + ")"); 
        } else { // 아니면 그 자리에 가만히 있고 현재 위치만 출력
            System.out.println("맵의 왼쪽 끝(1)입니다. 더 이상 나갈 수 없습니다. (현재 위치 : " + pos + ")");
        }
    }
    
    public void moveRight() {
        if (pos < 20) { // 플레이어 위치가 20미만이면 발동
            pos++;
            System.out.println("오른쪽으로 이동했습니다. (현재 위치 : " + pos + ")");
        } else { // 아니면 그 자리에 가만히 있고 현재 위치만 출력
            System.out.println("맵의 오른쪽 끝(20)입니다. 더 이상 나갈 수 없습니다. (현재 위치 : " + pos + ")");
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