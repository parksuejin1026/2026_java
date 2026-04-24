package thread_pro;

class MyThread extends Thread {
    @Override
    public void run() {
        // 1부터 9까지 반복하며 현재 스레드의 이름과 숫자를 출력
        for (int i = 1; i < 10; i++) {
            // getName()을 통해 스레드 식별 정보를 출력
            System.out.println(getName() + ": " + i);
        }
    }
}

public class SimpleThread {
    public static void main(String[] args) {
        // 1. 스레드 인스턴스 생성 (New 상태)
        MyThread th = new MyThread(); 
        
        // 2. 스레드 실행 시작 (Runnable 상태로 전이 후 스케줄링에 따라 run() 실행)
        th.start(); 
    }
}