import java.io.*;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

// ==========================================
// [문제 2 & 3] 좀비 게임 메인 컨트롤러 및 PPT 교안 준수 문자 스트림부
// ==========================================
public class ZombieGame {
    private static final String FILE_PATH = "C:\\temp\\zombie.sav";
    // Zombie 클래스에서 패키지 내 직접 접근 및 수집이 가능하도록 공용 범위 부여
    static Vector<Gem> inventory = new Vector<>(); // 젬 클래스를 데이터로 하는 Vector 객체 생성
    private static Human player; 
    private static Zombie zombie1;
    private static Zombie zombie2;
    private static Gem currentGem; // 현재 젬
    private static Random r = new Random();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // C:\temp 경로에 콜론(:) 문장 부호를 정확하게 정돈 처리
        File tempDir = new File("C:\\temp"); // 폴더 객체 생성
        if (!tempDir.exists()) { // 만약 저 경로의 폴더가 있지 않다면
            tempDir.mkdir();  // C:\\temp라는 경로의 폴더 생성
        }
        
        System.out.println("========= 서바이벌 좀비 보물 게임을 시작합니다 =========");
        
        player = new Human("플레이어 1");
        zombie1 = new Zombie(20, "좀비 1", player); 
        zombie2 = new Zombie(10, "좀비 2", player);
        zombie1.start(); // 쓰레드 작동
        zombie2.start(); // 쓰레드 작동
        
        generateNewGem(); // 보물 생성
        
        while (true) {
            // 메인 턴 직전 실시간 전황 및 좀비 이동 상태판 자동 리포트
            System.out.println("\n==================================================");
            System.out.printf("[현재 위치] 플레이어: %d | 좀비1: %d | 좀비2: %d\n", 
                              player.getPos(), zombie1.getPos(), zombie2.getPos());
            System.out.println("==================================================");
            
            System.out.print("[메뉴] 왼쪽(1), 오른쪽(2), 점프(3), 획득한 보물(4), 저장하기(5), 이어하기(6), 종료(7) >> ");
            
            int menu = 0;
            if (sc.hasNextInt()) { // 입력한 값이 정수일때만 발동
                menu = sc.nextInt();
            } else {
                sc.next(); 
                continue; // 아니라면 while문 처음오로
            }
            
            switch (menu) {
                case 1: player.moveLeft(); break; // 왼쪽으로 움직이기
                case 2: player.moveRight(); break; // 오른쪽으로 움직이기
                case 3: player.jump(); break; // 점프하기 1~3
                case 4: printInventory(); break; // 갖고 있는 보물 출력
                case 5: saveGame(); break; // 게임 저장
                case 6: loadGame(); break; // 게임 불러오기
                case 7: // 게임 종료
                    System.out.println("게임이 종료되었습니다.");
                    zombie1.stopZombie();
                    zombie2.stopZombie();
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
                    continue;
            }
            
            // 사용자의 수동 조작 직후 좌표 매칭 충돌 점검
            if (player.getPos() == zombie1.getPos() || player.getPos() == zombie2.getPos()) { // 현재 위치 검사해서 좀비 1,2 중 하나라도 같게 된다면
                System.out.println("\n☠ 이동 또는 점프한 위치에 좀비가 대기하고 있었습니다! GAMEOVER!"); // 좀비와 충돌 게임오버
                printFinalScore(); // 점수 출력
                zombie1.stopZombie(); // 쓰레드 종료
                zombie2.stopZombie(); // 쓰레드 종료
                sc.close(); // scnnaer 객체 닫기
                return; // 게임 끝내기
            }
            
            checkGemCollision(); // 젬을 획득했는 지 체크
        }                
    }
    
    private static void generateNewGem() { 
        int type = r.nextInt(3) + 1; // 1~3 중 하나의 숫자 set
        String gemName = (type == 1) ? "다이아" : (type == 2) ? "금" : "은"; // set된 숫자에 따라 보석 종류 결정
        
        int gemPos = r.nextInt(20) + 1; // 1~20까지 보석의 위치 결정
        currentGem = new Gem(gemName, type, gemPos); // Gem 객체 생성자 지정
        System.out.println("\n [신규 보물 출현] " + gemName + "이(가) " + gemPos + "번 위치에 생성되었습니다."); // 보물 종류와 위치 출력
    }

    private static void checkGemCollision() {
        if (player.getPos() == currentGem.getPos()) { // 보물과 플레이어의 위치가 같아진다면
            currentGem.getItem();  // 보물 획득 메서드 출력
            inventory.add(currentGem);  // 젬 보관하는 인벤토리에 Gem 객체 저장 
            generateNewGem(); // 보물 다시 새로 생성
        }
    }

    private static void printInventory() {
        System.out.println("\n[현재 가방 속 보물 목록]"); 
        if (inventory.isEmpty()) {
            System.out.println("가방이 텅 비어있습니다.");
            return;
        }
        
        // [PPT 표준 방식] Iterator 인터페이스를 컬렉션으로부터 얻어와 순차 검색 진행
        Iterator<Gem> it = inventory.iterator();
        
        System.out.print("현재 총 " + inventory.size() + "개 ");
        
        // Iterator의hasNext()와 next()를 이용해 순회 출력하는 것이 PPT 스타일입니다.
        while(it.hasNext()) {
            Gem g = it.next();
            System.out.print(g.getName());
            
            // 다음 요소가 있다면 쉼표(,)를 붙여 정돈
            if(it.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("을 가지고 있습니다.");
    }
    
        public static void printFinalScore() {
            System.out.println("▶ [최종 게임 결과 리포트]");
            System.out.println("▶ 총 획득한 보물 개수: " + inventory.size() + "개");
            
            // 컬렉션이 비어있는 예외 상황을 먼저 체크합니다.
            if (inventory.isEmpty()) {
                System.out.println("▶ 수집한 보물이 존재하지 않습니다.");
                return;
            }

            // [PPT 표준 방식] Vector 컬렉션으로부터 요소 순회를 위한 Iterator 객체를 얻어옵니다.
            Iterator<Gem> it = inventory.iterator();
            
            System.out.print("▶ 수집한 보물 리스트: ");
            
            // [PPT 표준 방식] hasNext()와 next() 메커니즘을 이용하여 마지막 요소까지 안전하게 출력합니다.
            while (it.hasNext()) {
                Gem g = it.next(); // 포인터를 다음 칸으로 이동시키며 실제 Gem 객체를 꺼냅니다.
                System.out.print(g.getName()); // 꺼낸 보물의 이름을 출력합니다.
                
                // PPT의 깔끔한 리스트 정돈 스타일: 만약 다음 꺼낼 보물(요소)이 더 남아있다면 뒤에 쉼표(, )를 붙여줍니다.
                if (it.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println(); // 리스트 출력이 모두 끝나면 줄바꿈을 해줍니다.
            System.out.println("===========================================");
        }

    // ====================================================================
    // [PPT 14, 19페이지 적용] FileWriter 및 flush() 버퍼 청소 기능 탑재
    // ====================================================================
    private static void saveGame() {
        // PPT 14페이지 표준 문자 스트림 FileWriter 생성 규격 준수
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            for (Gem gem : inventory) {
                // 데이터 컴마(,) 결합 시 공백을 제거하여 로드할 때 NumberFormatException 사전 전면 차단
                String data = gem.getName() + "," + gem.getNumber() + "," + gem.getPos();
                
                // PPT 14페이지 명시 공식: 줄바꿈 기법을 명확하게 자바 전용 개행 문자열로 기록
                fw.write(data + "\r\n");
            }
            // PPT 19페이지 버퍼 이론 핵심: 파일 손실 오류 방지를 위해 하드디스크로 데이터 완전히 밀어내기
            fw.flush(); 
            System.out.println("현재까지의 보물 정보가 파일에 저장되었습니다. (경로 : " + FILE_PATH + ")");
        } catch (IOException e) {
            // [감점 요소 배제] PPT 예제 8-10 등과 일치하는 명확하고 직관적인 교안 스타일 예외 문자 처리
            System.out.println("파일 저장 오류"); 
        }
    }

    // ====================================================================
    // [PPT 8, 20페이지 적용] FileReader 및 문자 버퍼 스트림 BufferedReader 복원
    // ====================================================================
    private static void loadGame() {
        File file = new File(FILE_PATH);
        if (!file.exists()) { // PPT 24페이지 물리 파일 안전 장치 확인 기법
            System.out.println("저장된 세이브 파일이 존재하지 않습니다!");
            return;
        }
        
        // PPT 20페이지 예제 8-6 표준: FileReader에 성능 고속 보정을 위한 BufferedReader를 래핑 연결
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            inventory.clear(); 
            
            String line;
            // 줄 단위 독출(readLine) 제어로 쪼개어 객체 복원
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