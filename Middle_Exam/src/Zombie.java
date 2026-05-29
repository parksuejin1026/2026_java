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
    public void stopZombie() { this.running = false; }
    
    @Override
    public void run() {
        while (running) {
            try {
                // [요구사항] 1초에서 2초 사이 무작위 랜덤 딜레이 대기
                int sleepTime = r.nextInt(1001) + 1000;
                Thread.sleep(sleepTime);
                
                // 1 ~ 20 영역 안에서 실시간 자동 좌우 이동
                int move = r.nextBoolean() ? 1 : -1;
                pos += move;
                if (pos < 1) pos = 1;
                if (pos > 20) pos = 20;
                
                // ------------------------------------------------------------------
                // [실시간 융합 판정] 플레이어가 입력을 대기하느라 블로킹 상태로 정지해 있어도
                // 좀비가 알아서 사냥 범위를 좁혀 덮치는 순간 JVM을 실시간 종료 시킵니다.
                // ------------------------------------------------------------------
                if (this.pos == player.getPos()) {
                    System.out.println("\n☠ " + name + "와(과) 부딪혔습니다! GAMEOVER!");
                    ZombieGame.printFinalScore(); // 최종 누적 스코어 요약 보고
                    System.exit(0); // 얼어붙어 있는 메인 스레드까지 깔끔하게 일괄 셧다운
                }
                
            } catch (InterruptedException e) {
                // 잠 자는 도중 인터럽트 종료 지시를 감지하면 루프를 안전하게 강제 이탈
                break;
            }
        }
    }
}