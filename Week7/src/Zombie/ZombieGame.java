package Zombie;

import java.io.*;
import java.util.Scanner;

public class ZombieGame {
    static Hero h;
    static Zombie z1, z2;
    static final String FILE_PATH = "c:\\zombie.sav";

    public static void main(String[] args) {
        loadGame(); // 시작 시 데이터 불러오기

        Scanner sc = new Scanner(System.in);
        System.out.println("=== 좀비 게임 시작 ===");

        while (true) {
            System.out.print("\n1.왼쪽 2.오른쪽 3.점프 0.저장후종료 : ");
            int menu = sc.nextInt();

            if (menu == 0) {
                saveGame(); // 종료 시 데이터 저장
                break;
            }

            // 1. 주인공 이동
            if (menu == 1) h.leftMove();
            else if (menu == 2) h.rightMove();
            else if (menu == 3) h.jump();

            // 위치 보정 및 승리 체크
            if (h.curPos <= 0) h.curPos = 1;
            if (h.curPos >= 20) {
                System.out.println("축하합니다! 탈출 성공!");
                break;
            }

            // 2. 좀비 이동 및 충돌 체크 (중복 로직 메서드화)
            z1.move();
            z2.move();

            if (checkCollision()) {
                if (h.lifePoint <= 0) {
                    System.out.println("Game Over!!");
                    break;
                }
            }
        }
    }

    // 충돌 체크 로직 단순화
    private static boolean checkCollision() {
        if (h.curPos == z1.curPos || h.curPos == z2.curPos) {
            h.lifePoint--;
            h.curPos = 1; // 충돌 시 처음으로
            System.out.println("좀비와 부딪혔습니다! 처음 위치로 이동. 남은 생명: " + h.lifePoint);
            return true;
        }
        return false;
    }

    // 파일 저장 기능 (BufferedWriter 활용)
    private static void saveGame() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            // 주인공위치 생명 좀비1위치 좀비2위치 순서로 저장
            String data = h.curPos + " " + h.lifePoint + " " + z1.curPos + " " + z2.curPos;
            bw.write(data);
            System.out.println("게임이 저장되었습니다: " + data);
        } catch (IOException e) {
            System.out.println("저장 실패: " + e.getMessage());
        }
    }

    // 파일 불러오기 기능 (BufferedReader 활용)
    private static void loadGame() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line != null) {
                    String[] data = line.split(" "); // 스페이스로 구분
                    h = new Hero("호날두", Integer.parseInt(data[0]), Integer.parseInt(data[1]));
                    z1 = new Zombie("좀비1", Integer.parseInt(data[2]));
                    z2 = new Zombie("좀비2", Integer.parseInt(data[3]));
                    System.out.println("이전 게임을 불러왔습니다.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("파일 읽기 오류, 새로 시작합니다.");
            }
        }
        // 파일이 없거나 오류 시 기본값으로 시작
        h = new Hero("호날두", 1, 3);
        z1 = new Zombie("좀비1", 7);
        z2 = new Zombie("좀비2", 15);
        System.out.println("새 게임을 시작합니다.");
    }
}