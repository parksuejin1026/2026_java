package thread_pro;

/**
 * 숫자를 증가시키며 출력하는 스레드 클래스
 */
class IncThread extends Thread {
    // 생성자 정의
    public IncThread(String name) {
        setName(name); // 스레드 이름 설정
    }
    
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                // 50ms 동안 대기 (스레드 컨텍스트 스위칭 유도)
                Thread.sleep(50);
                System.out.print(getName() + ": " + i);
                // 현재 실행 중인 활성 스레드 수 출력
                System.out.println(", 활성화된 스레드 수: " + Thread.activeCount());
            } catch (InterruptedException e) {
                // 인터럽트 발생 시 로그 출력 및 스레드 종료 처리
                System.err.println("스레드 중단됨: " + e.getMessage());
                Thread.currentThread().interrupt(); 
            }
        }
    }
}

/**
 * 숫자를 감소시키며 출력하는 스레드 클래스
 */
class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 5; i > 1; i--) {
            try {
                Thread.sleep(50);
                System.out.print(getName() + ": " + i);
                System.out.println(", 활성화된 스레드 수: " + Thread.activeCount());
            } catch (InterruptedException e) {
                System.err.println("스레드 중단됨: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        // 1. 증가 스레드 생성 및 시작
        IncThread inc = new IncThread("증가 스레드");
        inc.start();

        // 2. 감소 스레드 생성 및 시작
        DecThread dec = new DecThread();
        dec.setName("감소 스레드"); // 이름을 명시적으로 설정
        dec.start();        
    }
}