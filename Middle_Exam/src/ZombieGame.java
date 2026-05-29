import java.io.*;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class ZombieGame {
    private static final String FILE_PATH = "C:\\temp\\zombie.sav";
 
    static Vector<Gem> inventory = new Vector<>();
    private static Human player; 
    private static Zombie zombie1;
    private static Zombie zombie2;
    private static Gem currentGem; 
    private static Random r = new Random();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        File tempDir = new File("C:\\temp");
        if (!tempDir.exists()) {
            tempDir.mkdir();  
        }
        
        System.out.println("========= 서바이벌 좀비 보물 게임을 시작합니다 =========");
        
        player = new Human("플레이어 1");
        zombie1 = new Zombie(20, "좀비 1", player); 
        zombie2 = new Zombie(10, "좀비 2", player);
        zombie1.start(); 
        zombie2.start();
        
        generateNewGem();
        
        while (true) {
            System.out.println("\n==================================================");
            System.out.printf("[현재 위치] 플레이어: %d | 좀비1: %d | 좀비2: %d\n", 
                              player.getPos(), zombie1.getPos(), zombie2.getPos());
            System.out.println("==================================================");
            
            System.out.print("[메뉴] 왼쪽(1), 오른쪽(2), 점프(3), 획득한 보물(4), 저장하기(5), 이어하기(6), 종료(7) >> ");
            
            int menu = 0;
            if (sc.hasNextInt()) {
                menu = sc.nextInt();
            } else {
                sc.next(); 
                continue; 
            }
            
            switch (menu) {
                case 1: player.moveLeft(); break; 
                case 2: player.moveRight(); break; 
                case 3: player.jump(); break; 
                case 4: printInventory(); break; 
                case 5: saveGame(); break; 
                case 6: loadGame(); break; 
                case 7:
                    System.out.println("게임이 종료되었습니다.");
                    zombie1.stopZombie();
                    zombie2.stopZombie();
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
                    continue;
            }

            if (player.getPos() == zombie1.getPos() || player.getPos() == zombie2.getPos()) { 
                System.out.println("\n☠ 이동 또는 점프한 위치에 좀비가 대기하고 있었습니다! GAMEOVER!"); 
                printFinalScore(); 
                zombie1.stopZombie(); 
                zombie2.stopZombie(); 
                sc.close(); 
                return; 
            }
            
            checkGemCollision(); 
        }                
    }
    
    private static void generateNewGem() { 
        int type = r.nextInt(3) + 1; 
        String gemName = (type == 1) ? "다이아" : (type == 2) ? "금" : "은"; 
        
        int gemPos = r.nextInt(20) + 1; 
        currentGem = new Gem(gemName, type, gemPos); 
        System.out.println("\n [신규 보물 출현] " + gemName + "이(가) " + gemPos + "번 위치에 생성되었습니다."); 
    }

    private static void checkGemCollision() {
        if (player.getPos() == currentGem.getPos()) {
            currentGem.getItem();  
            inventory.add(currentGem);   
            generateNewGem(); 
        }
    }

    private static void printInventory() {
        System.out.println("\n[현재 가방 속 보물 목록]"); 
        if (inventory.isEmpty()) {
            System.out.println("가방이 텅 비어있습니다.");
            return;
        }
        
        Iterator<Gem> it = inventory.iterator();
        
        System.out.print("현재 총 " + inventory.size() + "개 ");
        
        while(it.hasNext()) {
            Gem g = it.next();
            System.out.print(g.getName());
            
            if(it.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("을 가지고 있습니다.");
    }
    
        public static void printFinalScore() {
            System.out.println("▶ [최종 게임 결과 리포트]");
            System.out.println("▶ 총 획득한 보물 개수: " + inventory.size() + "개");

            if (inventory.isEmpty()) {
                System.out.println("▶ 수집한 보물이 존재하지 않습니다.");
                return;
            }

            Iterator<Gem> it = inventory.iterator();
            
            System.out.print("▶ 수집한 보물 리스트: ");

            while (it.hasNext()) {
                Gem g = it.next();
                System.out.print(g.getName());

                if (it.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println("===========================================");
        }

    private static void saveGame() {
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            for (Gem gem : inventory) {
                String data = gem.getName() + "," + gem.getNumber() + "," + gem.getPos();

                fw.write(data + "\r\n");
            }
            fw.flush(); 
            System.out.println("현재까지의 보물 정보가 파일에 저장되었습니다. (경로 : " + FILE_PATH + ")");
        } catch (IOException e) {
            System.out.println("파일 저장 오류"); 
        }
    }
    
    private static void loadGame() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("저장된 세이브 파일이 존재하지 않습니다!");
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            inventory.clear(); 
            
            String line;
            while((line = br.readLine()) != null) { 
                if (line.trim().isEmpty()) continue;
                
                String[] tokens = line.split(",");
                String name = tokens[0];
                int number = Integer.parseInt(tokens[1].trim());
                int pos = Integer.parseInt(tokens[2].trim()); // trim() 안전 이중화
                
                inventory.add(new Gem(name, number, pos));
            }
            
            System.out.println("세이브 파일을 성공적으로 읽어왔습니다! 이어서 시작합니다.");
            printInventory(); 
        } catch (IOException e) {
            System.out.println("파일 읽기 오류");
        }
    }
}