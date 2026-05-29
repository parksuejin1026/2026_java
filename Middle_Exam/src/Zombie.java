import java.util.Random;

// ==========================================
// 좀비 클래스 (스레드로 동작하며 실시간 감시 엔진 내장)
// ==========================================
public class Zombie extends Thread {
    private int pos;
    private String name;
    private boolean running = true;
    private Random r = new Random();
    private Human player;
    
    public Zombie(int pos, String name, Human player) {
        this.pos = pos;
        this.name = name;
        this.player = player;
    }
    
    public int getPos() { return pos; }
    public void stopZombie() { this.running = false; } // Thread를 종료 시키기 위해 while문에 있는 참, 거짓 조건 변수
    
    @Override
    public void run() {
        while (running) {
            try {
                int sleepTime = r.nextInt(1001) + 1000; // 1~2초 대기하기 위한 변수
                Thread.sleep(sleepTime); // 1~2초 수면
                
                int move = r.nextBoolean() ? 1 : -1; // 왼쪽, 오른쪽
                pos += move; 
                if (pos < 1) pos = 1;
                if (pos > 20) pos = 20;
                
                if (this.pos == player.getPos()) {
                    System.out.println("\n☠ " + name + "와(과) 부딪혔습니다! GAMEOVER!");
                    ZombieGame.printFinalScore(); // 최종 스코어 보고
                    System.exit(0); // 쓰레드들도 모두 강제 종료
                }
                
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}