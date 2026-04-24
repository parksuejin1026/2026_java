package thread_pro;

import java.util.Random;

/**
 * 스레드 대기(wait) 및 알림(notify)을 이용한 은행 계좌 클래스
 */
class WaitBankAccount {
    int balance = 0; // 잔액
    int diff = 0;

    // 출금 메서드: 동기화 보장
    public synchronized void withdraw(int money) {
        if (money < 0) {
            System.out.println("출금 금액이 잘못되었습니다.");
            return;
        }
        
        int count = 0;
        // 잔액이 부족할 경우 대기 상태로 진입
        while (balance < money) {
            System.out.printf("[%s] ", Thread.currentThread().getName());
            
            // 무한 대기를 방지하기 위한 카운트 체크
            if (++count > 3) {
                System.out.println("잔액 부족으로 출금 처리를 포기하고 종료합니다.");
                return;
            }

            System.out.printf("%16s", "wait() 호출: ");
            System.out.printf("출금요구금액=%6d, 현재잔액=%6d %n", money, balance);
            
            try {
                // 모니터 락을 일시적으로 해제하고 Wait Set에서 대기
                wait(); 
            } catch (InterruptedException e) {
                System.err.println("스레드 중단 발생: " + e.getMessage());
                Thread.currentThread().interrupt(); // 인터럽트 상태 유지
            }
        }

        // 출금 수행 로직
        System.out.printf("[%s] ", Thread.currentThread().getName());
        balance -= money;
        System.out.printf(" %12s 출금수행금액=%6d, 현재잔액=%6d %n", "출금 처리 완료:", money, balance);
    }

    // 입금 메서드: 동기화 보장
    public synchronized void deposit(int money) {
        if (money < 0) {
            System.out.println("입금 금액이 잘못되었습니다.");
            return;
        }
        
        balance += money;
        System.out.printf("[%s] ", Thread.currentThread().getName());
        System.out.printf("%16s", "notify() 호출: ");
        System.out.printf("입금성공금액=%6d, 현재잔액=%6d %n", money, balance);

        // 대기실(Wait Set)에서 잠자고 있는 스레드 하나를 깨움
        notify(); 
    }
}

public class WaitSyncTest implements Runnable {
    private final WaitBankAccount act = new WaitBankAccount();

    @Override
    public void run() {
        for (int i = 1; i < 3; i++) {
            // 10,000 ~ 50,000 사이의 만 단위 금액 랜덤 생성
            int amount = (int) (new Random().nextDouble() * 5 + 1) * 10000;
            act.deposit(amount);
            
            amount = (int) (new Random().nextDouble() * 5 + 1) * 10000;
            act.withdraw(amount);
        }
    }

    public static void main(String[] args) {
        Runnable r = new WaitSyncTest();
        // 동일한 객체를 공유하는 두 개의 스레드 실행
        new Thread(r, "스레드-1").start();
        new Thread(r, "스레드-2").start();
    }
}