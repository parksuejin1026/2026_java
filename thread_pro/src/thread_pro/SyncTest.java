package thread_pro;

import java.util.Random;

/**
 * 은행 계좌 클래스 (공유 자원)
 */
class BankAccount {
    int balance = 0; // 잔액

    // 출금 메서드: 동기화를 위해 synchronized 추가
    public synchronized void withdraw(int money) {
        if (money > 0 && balance >= money) {
            try {
                // 문제 상황을 명확히 확인하기 위해 지연 시간 추가
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
            balance -= money;
            System.out.printf("%d 출금하여 현재잔고 %d입니다. %n", money, balance);
        } else if (balance < money) {
            System.out.println("잔액이 부족하여 출금할 수 없습니다.");
        }
    }

    // 입금 메서드: 동기화를 위해 synchronized 추가
    public synchronized void deposit(int money) {
        if (money > 0) {
            balance += money;
            System.out.printf("%d 입금하여 현재잔고 %d입니다. %n", money, balance);
        }
    }
}

public class SyncTest implements Runnable {
    BankAccount act = new BankAccount();

    @Override
    public void run() {
        while (true) {
            int amount = new Random().nextInt(10000);
            amount = (amount % 10) * 1000; // 천 단위 금액 설정
            
            System.out.printf("[%s] 거래 금액=%d %n", Thread.currentThread().getName(), amount);
            
            act.deposit(amount);
            act.withdraw(amount * 2);
            
            // 데이터 무결성 체크
            if (act.balance < 0) {
                System.out.printf("[%s] ", Thread.currentThread().getName());
                System.out.println("잔고: " + act.balance + " => 데이터 오류 발생");
                return;
            }
        }
    }
    
    public static void main(String[] args) {
        Runnable r = new SyncTest();
        // 두 개의 스레드가 하나의 BankAccount(공유 자원)를 참조
        new Thread(r).start();
        new Thread(r).start();
    }
}