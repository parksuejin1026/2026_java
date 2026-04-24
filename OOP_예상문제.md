# 🎯 객체지향 프로그래밍 시험 예상문제집
> **형식**: 배운 모든 내용(OOP · Collection · Thread · Stream · File I/O)을 종합한 프로그램 작성 문제  
> **난이도**: ⭐ 기본 → ⭐⭐⭐⭐⭐ 심화  
> **사용법**: 각 문제를 30~50분 내에 푸는 연습 → 모범답안과 비교 → 요구사항별 구현 패턴 체크

---

## 📑 목차

- [문제 1. 던전 탐험 RPG 게임](#문제-1-던전-탐험-rpg-게임-) ⭐⭐⭐
- [문제 2. 도서관 대출 관리 시스템](#문제-2-도서관-대출-관리-시스템-) ⭐⭐⭐
- [문제 3. 실시간 경주 시뮬레이션](#문제-3-실시간-경주-시뮬레이션-) ⭐⭐⭐⭐
- [문제 4. 좀비 아포칼립스 (종합판)](#문제-4-좀비-아포칼립스-종합판-) ⭐⭐⭐⭐⭐
- [문제 5. 은행 계좌 관리 시스템](#문제-5-은행-계좌-관리-시스템-) ⭐⭐⭐⭐
- [문제 6. 주식 거래 시뮬레이터](#문제-6-주식-거래-시뮬레이터-) ⭐⭐⭐⭐⭐
- [문제 7. 학사 관리 시스템 (미니)](#문제-7-학사-관리-시스템-미니-) ⭐⭐⭐
- [⚡ 각 문제 공통 채점 기준](#-각-문제-공통-채점-기준)

---

## 문제 1. 던전 탐험 RPG 게임 ⭐⭐⭐

### 📋 요구사항

1~20 위치의 던전에서 **용사(Hero)**가 **몬스터들(Monster/Boss)**과 싸우며 20번 위치의 보스를 물리치는 게임을 만드시오.

**필수 구현 사항:**
- [ ] `Character` 추상 클래스: `name`, `hp`, `atk` 필드 + `attack()` 추상 메서드
- [ ] `Hero`는 `Character`를 상속받아 사용자 입력(1:공격, 2:방어, 3:회복)으로 행동
- [ ] `Monster`는 `Character`를 상속, 랜덤으로 공격
- [ ] `Boss`는 `Monster`를 상속, 20% 확률로 필살기(2배 데미지) 사용
- [ ] `Vector<Monster>`에 몬스터 3마리 저장
- [ ] Hero가 몬스터 잡을 때마다 `HashMap<String, Integer>` (몬스터명 → 잡은 횟수) 업데이트
- [ ] Stream으로 "가장 많이 잡은 몬스터" 출력
- [ ] 게임 종료 시 전적을 `dungeon_log.txt`에 저장

### 💡 출제 의도
- 상속 3단계 (Character → Monster → Boss)
- 다형성 (다형성 공격 배열 순회)
- Vector + HashMap 동시 사용
- Stream 집계

### ✅ 모범답안 (핵심만)

```java
// Character.java
public abstract class Character {
    protected String name;
    protected int hp;
    protected int atk;

    public Character(String name, int hp, int atk) {
        this.name = name; this.hp = hp; this.atk = atk;
    }

    public abstract void attack(Character enemy);
    public boolean isAlive() { return hp > 0; }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public void takeDamage(int d) { hp = Math.max(0, hp - d); }
}

// Hero.java
public class Hero extends Character {
    private final Scanner sc = new Scanner(System.in);

    public Hero(String name, int hp, int atk) { super(name, hp, atk); }

    @Override
    public void attack(Character enemy) {
        System.out.print("(1)공격 (2)방어 (3)회복: ");
        int cmd = sc.nextInt();
        switch (cmd) {
            case 1:
                int dmg = new Random().nextInt(atk) + 1;
                enemy.takeDamage(dmg);
                System.out.println(name + "이 " + enemy.getName() + "에게 " + dmg + " 데미지");
                break;
            case 2:
                System.out.println("방어 태세");
                break;
            case 3:
                hp += 20;
                System.out.println("회복! HP: " + hp);
                break;
        }
    }
}

// Monster.java
public class Monster extends Character {
    public Monster(String name, int hp, int atk) { super(name, hp, atk); }

    @Override
    public void attack(Character enemy) {
        int dmg = new Random().nextInt(atk) + 1;
        enemy.takeDamage(dmg);
        System.out.println(name + "이 " + enemy.getName() + "에게 " + dmg + " 데미지");
    }
}

// Boss.java
public class Boss extends Monster {
    public Boss(String name, int hp, int atk) { super(name, hp, atk); }

    @Override
    public void attack(Character enemy) {
        if (new Random().nextFloat() > 0.8) {
            int dmg = atk * 2;
            enemy.takeDamage(dmg);
            System.out.println(name + "의 필살기! " + dmg + " 데미지");
        } else {
            super.attack(enemy);
        }
    }
}

// Game.java
public class Game {
    public static void main(String[] args) {
        Hero hero = new Hero("용사", 100, 20);
        Vector<Monster> monsters = new Vector<>();
        monsters.add(new Monster("슬라임", 30, 10));
        monsters.add(new Monster("오크", 50, 15));
        monsters.add(new Boss("드래곤", 100, 25));

        HashMap<String, Integer> killCount = new HashMap<>();

        for (Monster m : monsters) {
            System.out.println("\n=== " + m.getName() + " 등장! ===");
            while (hero.isAlive() && m.isAlive()) {
                hero.attack(m);
                if (m.isAlive()) m.attack(hero);
            }
            if (!hero.isAlive()) { System.out.println("패배..."); break; }
            killCount.merge(m.getName(), 1, Integer::sum);
        }

        // Stream으로 최고 킬 출력
        killCount.entrySet().stream()
                .max((a, b) -> a.getValue() - b.getValue())
                .ifPresent(e -> System.out.println("최다 킬: " + e.getKey()));

        // 파일 저장
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./dungeon_log.txt"))) {
            for (Map.Entry<String, Integer> e : killCount.entrySet()) {
                bw.write(e.getKey() + " " + e.getValue() + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
```

---

## 문제 2. 도서관 대출 관리 시스템 ⭐⭐⭐

### 📋 요구사항

도서관의 책 대출/반납을 관리하는 프로그램을 만드시오.

**필수 구현 사항:**
- [ ] `Book` 클래스: `title`, `author`, `isbn`, `isLent`(대출여부), `lenderName`
- [ ] `HashMap<String, Book>`으로 ISBN을 key로 관리
- [ ] 메뉴: 1.책등록 2.대출 3.반납 4.전체조회 5.검색(제목) 6.대출중인책만 7.저장 8.불러오기 9.종료
- [ ] 검색은 Stream `filter`로 제목에 키워드가 포함된 모든 책 출력
- [ ] 정렬: 제목 가나다순 (`Comparator` 또는 람다)
- [ ] 프로그램 시작 시 `library.txt` 자동 로드
- [ ] `try-with-resources`로 파일 I/O

### 💡 출제 의도
- HashMap CRUD
- Stream filter + sorted
- File I/O + 파일 포맷 설계
- 상태 관리 (대출 여부)

### ✅ 모범답안 (핵심만)

```java
// Book.java
public class Book {
    String title, author, isbn, lenderName;
    boolean isLent;

    public Book(String title, String author, String isbn) {
        this.title = title; this.author = author; this.isbn = isbn;
        this.isLent = false; this.lenderName = "";
    }

    public void print() {
        System.out.printf("%s | %s | %s | %s | %s%n",
                isbn, title, author,
                isLent ? "대출중" : "대출가능",
                lenderName);
    }

    public String toLine() {
        return isbn + "," + title + "," + author + "," + isLent + "," + lenderName;
    }

    public static Book fromLine(String line) {
        String[] d = line.split(",", -1);
        Book b = new Book(d[1], d[2], d[0]);
        b.isLent = Boolean.parseBoolean(d[3]);
        b.lenderName = d[4];
        return b;
    }
}

// Library.java
public class Library {
    static final String FILE = "./library.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Book> books = new HashMap<>();
        load(books);

        while (true) {
            System.out.println("\n1.등록 2.대출 3.반납 4.전체 5.검색 6.대출중 7.저장 8.불러오기 9.종료");
            int cmd = sc.nextInt(); sc.nextLine();

            if (cmd == 1) {
                System.out.print("ISBN 제목 저자: ");
                String[] d = sc.nextLine().split(" ");
                books.put(d[0], new Book(d[1], d[2], d[0]));
            }
            else if (cmd == 2) {
                System.out.print("ISBN 대출자: ");
                String[] d = sc.nextLine().split(" ");
                Book b = books.get(d[0]);
                if (b != null && !b.isLent) {
                    b.isLent = true; b.lenderName = d[1];
                    System.out.println("대출 완료");
                } else System.out.println("대출 불가");
            }
            else if (cmd == 3) {
                System.out.print("ISBN: ");
                Book b = books.get(sc.nextLine());
                if (b != null && b.isLent) {
                    b.isLent = false; b.lenderName = "";
                    System.out.println("반납 완료");
                }
            }
            else if (cmd == 4) {
                books.values().stream()
                     .sorted((a, b) -> a.title.compareTo(b.title))
                     .forEach(Book::print);
            }
            else if (cmd == 5) {
                System.out.print("검색어: ");
                String q = sc.nextLine();
                books.values().stream()
                     .filter(b -> b.title.contains(q))
                     .forEach(Book::print);
            }
            else if (cmd == 6) {
                books.values().stream()
                     .filter(b -> b.isLent)
                     .forEach(Book::print);
            }
            else if (cmd == 7) save(books);
            else if (cmd == 8) { books.clear(); load(books); }
            else if (cmd == 9) break;
        }
        sc.close();
    }

    static void load(HashMap<String, Book> books) {
        File f = new File(FILE);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                Book b = Book.fromLine(line);
                books.put(b.isbn, b);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    static void save(HashMap<String, Book> books) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (Book b : books.values()) bw.write(b.toLine() + "\n");
        } catch (IOException e) { e.printStackTrace(); }
    }
}
```

---

## 문제 3. 실시간 경주 시뮬레이션 ⭐⭐⭐⭐

### 📋 요구사항

여러 자동차가 **동시에** 결승점(100)까지 달리는 경주를 시뮬레이션하시오.

**필수 구현 사항:**
- [ ] `Car` 추상 클래스: `name`, `position` + `abstract move()`
- [ ] `SportsCar extends Car`: 랜덤 3~7칸 이동
- [ ] `Truck extends Car`: 랜덤 1~3칸 이동 (단, 10% 확률로 고장나서 1초 정지)
- [ ] `Car`는 `Runnable`도 구현 → 각 차량이 **별도 스레드**로 동작
- [ ] 0.5초마다 한 번씩 이동
- [ ] 순위표는 `synchronized`로 보호되는 공유 `Vector<Car>` (먼저 결승선 넘는 순서대로 추가)
- [ ] 모든 차가 결승선 통과하면 종료, 결과를 `race_result.txt`에 저장

### 💡 출제 의도
- 추상 클래스 + Runnable 동시 사용
- 다수 스레드 동시 실행
- synchronized로 공유 자원 보호
- try-catch InterruptedException

### ✅ 모범답안 (핵심만)

```java
// Car.java
public abstract class Car implements Runnable {
    protected String name;
    protected int position;
    protected final RaceTracker tracker;
    protected static final int GOAL = 100;

    public Car(String name, RaceTracker tracker) {
        this.name = name; this.position = 0; this.tracker = tracker;
    }

    protected abstract int step();  // 한 번에 얼마나 이동?

    @Override
    public void run() {
        try {
            while (position < GOAL) {
                Thread.sleep(500);
                position += step();
                System.out.println(name + " 위치: " + Math.min(position, GOAL));
            }
            tracker.finish(this);  // 결승선 통과 등록
        } catch (InterruptedException e) {
            return;
        }
    }

    public String getName() { return name; }
}

// SportsCar.java
public class SportsCar extends Car {
    public SportsCar(String name, RaceTracker t) { super(name, t); }

    @Override
    protected int step() {
        return new Random().nextInt(5) + 3;   // 3~7
    }
}

// Truck.java
public class Truck extends Car {
    public Truck(String name, RaceTracker t) { super(name, t); }

    @Override
    protected int step() {
        try {
            if (new Random().nextFloat() < 0.1) {
                System.out.println(name + " 고장! 정지");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return new Random().nextInt(3) + 1;   // 1~3
    }
}

// RaceTracker.java
public class RaceTracker {
    private final Vector<Car> finishers = new Vector<>();

    public synchronized void finish(Car car) {
        if (!finishers.contains(car)) {
            finishers.add(car);
            System.out.println("🏁 " + car.getName() + " 결승!  " + finishers.size() + "등");
        }
    }

    public Vector<Car> getFinishers() { return finishers; }
}

// Race.java
public class Race {
    public static void main(String[] args) throws InterruptedException {
        RaceTracker tracker = new RaceTracker();
        List<Car> cars = List.of(
                new SportsCar("페라리", tracker),
                new SportsCar("람보르기니", tracker),
                new Truck("볼보", tracker),
                new Truck("벤츠", tracker)
        );

        List<Thread> threads = new ArrayList<>();
        for (Car c : cars) {
            Thread t = new Thread(c);
            t.start();
            threads.add(t);
        }

        for (Thread t : threads) t.join();   // 모든 스레드 종료 대기

        System.out.println("\n=== 최종 순위 ===");
        Vector<Car> result = tracker.getFinishers();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./race_result.txt"))) {
            for (int i = 0; i < result.size(); i++) {
                String line = (i + 1) + "등: " + result.get(i).getName();
                System.out.println(line);
                bw.write(line + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
```

---

## 문제 4. 좀비 아포칼립스 (종합판) ⭐⭐⭐⭐⭐

### 📋 요구사항

**수업에서 다룬 모든 개념을 총망라한 좀비 생존 게임**을 만드시오.

**필수 구현 사항:**
- [ ] `Unit` 추상 클래스 (공통 이동 로직)
- [ ] `Hero extends Unit`: 사용자 입력, HP 3
- [ ] `Zombie extends Unit implements Runnable`: 스레드로 1~2초마다 랜덤 이동
- [ ] `ZombieKing extends Zombie`: 랜덤 순간이동 (1~20 아무데나), 더 빠르게 움직임
- [ ] `HashMap<String, Zombie>`에 좀비 관리 + `ZombieKing` 1마리 포함
- [ ] Stream으로 충돌 검사 (`anyMatch`)
- [ ] 공유 자원(Hero 위치) `synchronized`로 보호
- [ ] 파일 I/O: 매 턴마다 `save.txt`에 저장, 시작 시 이어하기
- [ ] 게임 결과: HP 0되면 패배, 20번 도달 시 승리
- [ ] 승리/패배 시 `history.txt`에 전적 누적 저장 (append 모드)

### 💡 출제 의도
수업의 모든 주요 개념을 종합:
- 추상 클래스 + 상속 3단계 + 다형성
- Runnable + synchronized + interrupt
- HashMap + Stream
- File I/O (읽기/쓰기/이어쓰기)
- 예외 처리

### ✅ 모범답안

```java
// Unit.java
public abstract class Unit {
    protected String name;
    protected int pos;
    protected static final int MAP_MAX = 20;

    public Unit(String name, int pos) {
        this.name = name; this.pos = pos;
    }

    public synchronized void left()  { if (pos > 1) pos--; }
    public synchronized void right() { if (pos < MAP_MAX) pos++; }
    public synchronized int getPos() { return pos; }
    public synchronized void setPos(int p) { this.pos = p; }

    public String getName() { return name; }
    public abstract void move();
}

// Hero.java
public class Hero extends Unit {
    private int hp;
    private final Scanner sc = new Scanner(System.in);

    public Hero(String name, int pos, int hp) {
        super(name, pos);
        this.hp = hp;
    }

    @Override
    public void move() {
        System.out.print("(1)왼쪽 (2)오른쪽 (3)점프: ");
        int cmd = sc.nextInt();
        switch (cmd) {
            case 1: left(); break;
            case 2: right(); break;
            case 3:
                int jump = new Random().nextInt(3) + 1;
                synchronized (this) {
                    pos = Math.min(pos + jump, MAP_MAX);
                }
                break;
            default: System.out.println("잘못된 입력");
        }
    }

    public int getHp() { return hp; }
    public void damage() { hp--; }
}

// Zombie.java
public class Zombie extends Unit implements Runnable {
    protected final Hero hero;

    public Zombie(String name, int pos, Hero hero) {
        super(name, pos);
        this.hero = hero;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            while (true) {
                Thread.sleep((r.nextInt(2) + 1) * 1000);
                move();
            }
        } catch (InterruptedException e) { return; }
    }

    @Override
    public void move() {
        if (new Random().nextInt(2) == 0) left(); else right();
    }
}

// ZombieKing.java
public class ZombieKing extends Zombie {
    public ZombieKing(String name, int pos, Hero hero) {
        super(name, pos, hero);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);  // 더 빠름
                move();
            }
        } catch (InterruptedException e) { return; }
    }

    @Override
    public void move() {
        int newPos = new Random().nextInt(MAP_MAX) + 1;  // 순간이동
        setPos(newPos);
        System.out.println(name + " 순간이동 → " + newPos);
    }
}

// Game.java
public class Game {
    static final String SAVE = "./save.txt";
    static final String HISTORY = "./history.txt";

    public static void main(String[] args) {
        HashMap<String, Zombie> zombies = new HashMap<>();
        Hero hero = load(zombies);

        // 좀비 스레드 시작
        List<Thread> threads = new ArrayList<>();
        for (Zombie z : zombies.values()) {
            Thread t = new Thread(z);
            t.start();
            threads.add(t);
        }

        String result;
        while (true) {
            hero.move();

            // Stream 충돌 검사
            boolean caught = zombies.values().stream()
                    .anyMatch(z -> z.getPos() == hero.getPos());

            if (caught) {
                hero.damage();
                System.out.println("좀비에게 잡힘! HP: " + hero.getHp());
                hero.setPos(1);

                if (hero.getHp() <= 0) {
                    result = "패배";
                    System.out.println("게임 오버");
                    break;
                }
            }

            if (hero.getPos() == 20) {
                result = "승리";
                System.out.println("🎉 클리어!");
                break;
            }

            save(hero, zombies);
        }

        // 스레드 정리
        threads.forEach(Thread::interrupt);

        // 전적 누적 저장
        appendHistory(hero.getName(), result);
    }

    private static Hero load(HashMap<String, Zombie> zombies) {
        File f = new File(SAVE);
        Hero hero = null;

        if (f.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] d = line.split(" ");
                    if (d[0].equals("Hero")) {
                        hero = new Hero(d[1], Integer.parseInt(d[2]), Integer.parseInt(d[3]));
                    }
                }
                // 좀비 로드 (hero 먼저 로드 후 재순회)
                try (BufferedReader br2 = new BufferedReader(new FileReader(f))) {
                    String line2;
                    while ((line2 = br2.readLine()) != null) {
                        String[] d = line2.split(" ");
                        if (d[0].equals("Zombie")) {
                            zombies.put(d[1], new Zombie(d[1], Integer.parseInt(d[2]), hero));
                        } else if (d[0].equals("King")) {
                            zombies.put(d[1], new ZombieKing(d[1], Integer.parseInt(d[2]), hero));
                        }
                    }
                }
            } catch (IOException e) { e.printStackTrace(); }
        }

        if (hero == null) hero = new Hero("Hero", 1, 3);
        if (zombies.isEmpty()) {
            zombies.put("Z1", new Zombie("Z1", 7, hero));
            zombies.put("Z2", new Zombie("Z2", 15, hero));
            zombies.put("K1", new ZombieKing("K1", 10, hero));
        }
        return hero;
    }

    private static void save(Hero hero, HashMap<String, Zombie> zombies) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SAVE))) {
            bw.write("Hero " + hero.getName() + " " + hero.getPos() + " " + hero.getHp() + "\n");
            for (Zombie z : zombies.values()) {
                String type = (z instanceof ZombieKing) ? "King" : "Zombie";
                bw.write(type + " " + z.getName() + " " + z.getPos() + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void appendHistory(String name, String result) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(HISTORY, true))) {  // append
            bw.write(name + " " + result + " " + System.currentTimeMillis() + "\n");
        } catch (IOException e) { e.printStackTrace(); }
    }
}
```

---

## 문제 5. 은행 계좌 관리 시스템 ⭐⭐⭐⭐

### 📋 요구사항

멀티 스레드 환경에서 안전한 은행 시스템을 구현하시오.

**필수 구현 사항:**
- [ ] `Account` 클래스: `accountNo`, `owner`, `balance` + `deposit()`, `withdraw()` 메서드 (**synchronized**)
- [ ] `SavingsAccount extends Account`: 이자 계산 메서드 추가 (연 3%)
- [ ] `HashMap<String, Account>`로 계좌 관리
- [ ] `Transaction` 클래스 implements Runnable: 여러 스레드가 무작위로 입출금
- [ ] 최소 3개 스레드 동시 실행, 각 스레드는 100회씩 입출금 반복
- [ ] 모든 거래 내역을 `transactions.txt`에 기록 (스레드 이름 + 동작 + 금액)
- [ ] 거래 종료 후 Stream으로 "총 잔액"과 "잔액 상위 3개 계좌" 출력

### 💡 출제 의도
- **synchronized** 올바른 사용 (race condition 방지)
- 상속
- 멀티스레드 + HashMap
- Stream 집계 + 정렬 + limit

### ✅ 모범답안 (핵심만)

```java
// Account.java
public class Account {
    protected String accountNo;
    protected String owner;
    protected int balance;

    public Account(String accountNo, String owner, int balance) {
        this.accountNo = accountNo; this.owner = owner; this.balance = balance;
    }

    public synchronized void deposit(int money) {
        balance += money;
    }

    public synchronized boolean withdraw(int money) {
        if (balance >= money) {
            balance -= money;
            return true;
        }
        return false;
    }

    public synchronized int getBalance() { return balance; }
    public String getAccountNo() { return accountNo; }
    public String getOwner() { return owner; }
}

// SavingsAccount.java
public class SavingsAccount extends Account {
    public SavingsAccount(String no, String owner, int balance) {
        super(no, owner, balance);
    }

    public synchronized void addInterest() {
        balance += (int) (balance * 0.03);
    }
}

// Transaction.java
public class Transaction implements Runnable {
    private final HashMap<String, Account> accounts;
    private final BufferedWriter logger;
    private static final Object LOG_LOCK = new Object();

    public Transaction(HashMap<String, Account> accounts, BufferedWriter logger) {
        this.accounts = accounts; this.logger = logger;
    }

    @Override
    public void run() {
        Random r = new Random();
        String[] keys = accounts.keySet().toArray(new String[0]);

        for (int i = 0; i < 100; i++) {
            String key = keys[r.nextInt(keys.length)];
            Account a = accounts.get(key);
            int amount = r.nextInt(1000) + 100;
            String action;

            if (r.nextBoolean()) {
                a.deposit(amount);
                action = "입금";
            } else {
                action = a.withdraw(amount) ? "출금성공" : "출금실패";
            }

            // 파일 쓰기는 공유 자원이므로 락
            synchronized (LOG_LOCK) {
                try {
                    logger.write(Thread.currentThread().getName() + " " 
                               + key + " " + action + " " + amount + "\n");
                } catch (IOException e) { e.printStackTrace(); }
            }
        }
    }
}

// Bank.java
public class Bank {
    public static void main(String[] args) throws Exception {
        HashMap<String, Account> accounts = new HashMap<>();
        accounts.put("A001", new Account("A001", "홍길동", 10000));
        accounts.put("A002", new Account("A002", "김철수", 20000));
        accounts.put("A003", new SavingsAccount("S001", "이영희", 30000));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./transactions.txt"))) {
            Transaction task = new Transaction(accounts, bw);
            Thread t1 = new Thread(task, "T1");
            Thread t2 = new Thread(task, "T2");
            Thread t3 = new Thread(task, "T3");
            t1.start(); t2.start(); t3.start();
            t1.join(); t2.join(); t3.join();
        }

        // Stream 집계
        int total = accounts.values().stream()
                            .mapToInt(Account::getBalance)
                            .sum();
        System.out.println("총 잔액: " + total);

        System.out.println("\n=== 잔액 TOP 3 ===");
        accounts.values().stream()
                .sorted((a, b) -> b.getBalance() - a.getBalance())
                .limit(3)
                .forEach(a -> System.out.println(a.getAccountNo() + " " + a.getOwner() + ": " + a.getBalance()));
    }
}
```

---

## 문제 6. 주식 거래 시뮬레이터 ⭐⭐⭐⭐⭐

### 📋 요구사항

여러 주식 종목의 가격이 실시간으로 변동하고, 사용자는 매수/매도하는 시뮬레이터를 만드시오.

**필수 구현 사항:**
- [ ] `Stock` 클래스 implements Runnable: 종목명, 현재가, 이력(`Vector<Integer>`) → 1초마다 ±5% 변동
- [ ] `Portfolio` 클래스: `HashMap<String, Integer>` (종목 → 보유수량) + 현금잔고
- [ ] `Market` 클래스: 여러 `Stock`을 관리, 각각 스레드로 실행
- [ ] 사용자 메뉴: 1.시세 2.매수 3.매도 4.포트폴리오 5.평가액 6.저장 7.종료
- [ ] `synchronized`로 Stock 가격 접근 보호
- [ ] 평가액 = 현금 + (보유수량 × 현재가) 합계 (Stream 활용)
- [ ] 종료 시 포트폴리오와 가격 이력을 파일로 저장
- [ ] 실행 시 저장된 상태 이어서 시작

### 💡 출제 의도
- **모든 개념을 대규모로 종합**
- 여러 스레드 + synchronized
- Stream 복합 집계
- 복잡한 데이터 구조

### ✅ 모범답안 (핵심 구조만, 전체 구현 필요)

```java
// Stock.java
public class Stock implements Runnable {
    private final String name;
    private int price;
    private final Vector<Integer> history = new Vector<>();

    public Stock(String name, int price) {
        this.name = name; this.price = price;
        history.add(price);
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            while (true) {
                Thread.sleep(1000);
                synchronized (this) {
                    double change = (r.nextDouble() * 0.1) - 0.05;  // -5% ~ +5%
                    price = Math.max(1, (int) (price * (1 + change)));
                    history.add(price);
                }
            }
        } catch (InterruptedException e) { return; }
    }

    public synchronized int getPrice() { return price; }
    public String getName() { return name; }
    public synchronized Vector<Integer> getHistory() { return new Vector<>(history); }
}

// Portfolio.java
public class Portfolio {
    private int cash;
    private final HashMap<String, Integer> holdings = new HashMap<>();

    public Portfolio(int cash) { this.cash = cash; }

    public boolean buy(Stock stock, int qty) {
        int cost = stock.getPrice() * qty;
        if (cash >= cost) {
            cash -= cost;
            holdings.merge(stock.getName(), qty, Integer::sum);
            return true;
        }
        return false;
    }

    public boolean sell(Stock stock, int qty) {
        int owned = holdings.getOrDefault(stock.getName(), 0);
        if (owned >= qty) {
            cash += stock.getPrice() * qty;
            holdings.put(stock.getName(), owned - qty);
            return true;
        }
        return false;
    }

    public int evaluate(HashMap<String, Stock> stocks) {
        // Stream으로 평가액 계산
        int stockValue = holdings.entrySet().stream()
                .mapToInt(e -> stocks.get(e.getKey()).getPrice() * e.getValue())
                .sum();
        return cash + stockValue;
    }

    public void print(HashMap<String, Stock> stocks) {
        System.out.println("현금: " + cash);
        holdings.forEach((name, qty) -> {
            if (qty > 0) {
                System.out.printf("%s: %d주 × %d = %d%n",
                        name, qty, stocks.get(name).getPrice(),
                        qty * stocks.get(name).getPrice());
            }
        });
        System.out.println("총 평가액: " + evaluate(stocks));
    }

    // getter, save, load 생략
    public int getCash() { return cash; }
    public HashMap<String, Integer> getHoldings() { return holdings; }
}

// Market.java
public class Market {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Stock> stocks = new HashMap<>();
        stocks.put("삼성전자", new Stock("삼성전자", 70000));
        stocks.put("카카오", new Stock("카카오", 40000));
        stocks.put("네이버", new Stock("네이버", 180000));

        Portfolio portfolio = new Portfolio(1_000_000);

        // 모든 종목 스레드 시작
        List<Thread> threads = new ArrayList<>();
        for (Stock s : stocks.values()) {
            Thread t = new Thread(s);
            t.start(); threads.add(t);
        }

        while (true) {
            System.out.println("\n1.시세 2.매수 3.매도 4.포트폴리오 5.평가액 6.저장 7.종료");
            int cmd = sc.nextInt(); sc.nextLine();

            if (cmd == 1) {
                stocks.values().stream()
                      .sorted((a, b) -> b.getPrice() - a.getPrice())
                      .forEach(s -> System.out.println(s.getName() + ": " + s.getPrice()));
            }
            else if (cmd == 2) {
                System.out.print("종목명 수량: ");
                String[] d = sc.nextLine().split(" ");
                Stock s = stocks.get(d[0]);
                if (s != null && portfolio.buy(s, Integer.parseInt(d[1])))
                    System.out.println("매수 완료");
                else System.out.println("매수 실패");
            }
            else if (cmd == 3) {
                System.out.print("종목명 수량: ");
                String[] d = sc.nextLine().split(" ");
                Stock s = stocks.get(d[0]);
                if (s != null && portfolio.sell(s, Integer.parseInt(d[1])))
                    System.out.println("매도 완료");
                else System.out.println("매도 실패");
            }
            else if (cmd == 4) portfolio.print(stocks);
            else if (cmd == 5) System.out.println("평가액: " + portfolio.evaluate(stocks));
            else if (cmd == 6) { /* save 구현 */ }
            else if (cmd == 7) break;
        }

        threads.forEach(Thread::interrupt);
        sc.close();
    }
}
```

---

## 문제 7. 학사 관리 시스템 (미니) ⭐⭐⭐

### 📋 요구사항

학생의 여러 과목 성적을 관리하는 시스템을 만드시오.

**필수 구현 사항:**
- [ ] `Student` 클래스: `id`, `name`, `HashMap<String, Integer>` scores (과목 → 점수)
- [ ] `HashMap<String, Student>`로 학생 관리
- [ ] 메뉴: 1.학생등록 2.성적입력 3.학생검색 4.과목별평균 5.전체평균순위 6.장학생명단(평균90↑) 7.저장 8.종료
- [ ] Stream으로 평균 내림차순 정렬
- [ ] 각 학생의 평균은 `Student` 내부 메서드로 계산
- [ ] 파일: CSV 형식 `id,name,국어,영어,수학...`

### 💡 출제 의도
- 중첩된 자료구조 (Map 안에 Map)
- Stream 정렬/필터/집계
- CSV 파싱

### ✅ 모범답안 (핵심만)

```java
// Student.java
public class Student {
    String id, name;
    HashMap<String, Integer> scores = new HashMap<>();

    public Student(String id, String name) { this.id = id; this.name = name; }

    public void setScore(String subject, int score) { scores.put(subject, score); }

    public double average() {
        return scores.values().stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public int getScore(String subject) { return scores.getOrDefault(subject, 0); }

    public void print() {
        System.out.printf("%s %s 평균:%.2f ", id, name, average());
        scores.forEach((k, v) -> System.out.printf("%s:%d ", k, v));
        System.out.println();
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Student> students = new HashMap<>();

        while (true) {
            System.out.println("\n1.등록 2.성적입력 3.검색 4.과목평균 5.전체순위 6.장학생 7.저장 8.종료");
            int cmd = sc.nextInt(); sc.nextLine();

            if (cmd == 1) {
                System.out.print("학번 이름: ");
                String[] d = sc.nextLine().split(" ");
                students.put(d[0], new Student(d[0], d[1]));
            }
            else if (cmd == 2) {
                System.out.print("학번 과목 점수: ");
                String[] d = sc.nextLine().split(" ");
                Student s = students.get(d[0]);
                if (s != null) s.setScore(d[1], Integer.parseInt(d[2]));
            }
            else if (cmd == 3) {
                System.out.print("학번: ");
                Student s = students.get(sc.nextLine());
                if (s != null) s.print();
            }
            else if (cmd == 4) {
                System.out.print("과목명: ");
                String sub = sc.nextLine();
                double avg = students.values().stream()
                        .mapToInt(s -> s.getScore(sub))
                        .average().orElse(0);
                System.out.printf("%s 평균: %.2f%n", sub, avg);
            }
            else if (cmd == 5) {
                students.values().stream()
                        .sorted((a, b) -> Double.compare(b.average(), a.average()))
                        .forEach(Student::print);
            }
            else if (cmd == 6) {
                students.values().stream()
                        .filter(s -> s.average() >= 90)
                        .forEach(Student::print);
            }
            else if (cmd == 7) {
                // save 구현
            }
            else if (cmd == 8) break;
        }
        sc.close();
    }
}
```

---

## ⚡ 각 문제 공통 채점 기준

시험에서 다음 요소가 모두 들어있는지 확인하시기 바랍니다.

### ✅ 필수 체크리스트

| 항목 | 배점 예상 | 확인 |
|---|---|---|
| **OOP 기본** | | |
| 클래스 분리 (최소 3개) | 10% | ☐ |
| 캡슐화 (private 필드 + getter/setter) | 5% | ☐ |
| 생성자로 초기화 | 5% | ☐ |
| **상속 & 다형성** | | |
| `extends`로 상속 구현 | 10% | ☐ |
| `super()` 부모 생성자 호출 | 5% | ☐ |
| `@Override` 메서드 오버라이딩 | 10% | ☐ |
| 추상 클래스 또는 인터페이스 사용 | 10% | ☐ |
| **Collection** | | |
| Vector 또는 ArrayList 사용 | 5% | ☐ |
| HashMap 사용 | 10% | ☐ |
| **Stream** | | |
| filter / sorted / forEach 중 2개 이상 | 10% | ☐ |
| **Thread** | | |
| Thread 또는 Runnable 사용 | 10% | ☐ |
| `synchronized` 또는 `interrupt()` | 5% | ☐ |
| **File I/O** | | |
| BufferedReader/Writer 사용 | 10% | ☐ |
| try-with-resources 또는 try-catch | 5% | ☐ |
| **기타** | | |
| 예외 처리 (try-catch) | 5% | ☐ |
| 메뉴 기반 사용자 입력 루프 | 5% | ☐ |

### 🎯 만점 받는 팁

1. **요구사항 먼저 주석으로 나열** → 하나씩 ✅ 체크하며 구현
2. **클래스 이름을 명사로** (`Hero`, `Zombie`), **메서드를 동사로** (`move`, `attack`)
3. **`private` 우선** → 필요할 때만 `protected`/`public`
4. **synchronized는 공유 자원에만** (과도하게 쓰면 성능 저하)
5. **파일 I/O는 try-with-resources** 권장 (close 자동)
6. **Stream보다 for문이 안전**: 시간이 촉박하면 for문으로 먼저 통과시키고 여유 있을 때 Stream으로 리팩토링
7. **main은 간결하게**: 로직을 클래스/메서드로 분리

---

## 🧩 문제 유형 빠른 판단 가이드

출제된 문제를 보고 **어떤 템플릿을 활용할지** 빠르게 판단하세요.

| 문제에 이런 단어가 나오면... | 필요한 기술 |
|---|---|
| "동시에", "실시간", "매 초마다" | **Thread / Runnable** |
| "이름으로 검색", "ID로 조회" | **HashMap** |
| "정렬", "상위 N개", "랭킹" | **Stream + Comparator** |
| "저장", "이어하기", "로그" | **File I/O + try-with-resources** |
| "여러 종류의 몬스터/차량/사용자" | **추상 클래스 + 상속** |
| "공유 자원", "은행", "계좌" | **synchronized** |
| "평균", "합계", "최댓값" | **Stream 집계 (mapToInt)** |
| "필터링", "조건 만족하는 것만" | **Stream filter** |

---

**다양한 문제로 연습하시고, 시험장에서 차분하게 요구사항을 체크리스트화하며 구현하시면 됩니다. 🍀**

## 🤔 추가로 준비해드릴 수 있는 것

1. **위 문제 중 하나를 100% 완성된 형태의 별도 파일**로 만들어드릴까요? (실제로 컴파일·실행되는 전체 코드)
2. **30분 안에 푸는 속도 훈련용 미니 문제 10개**를 추가로 만들어드릴까요?
3. **이전 치트시트와 이 예상문제집을 하나의 PDF**로 통합해드릴까요?
4. **자주 틀리는 컴파일 에러 모음**을 별도로 정리해드릴까요?
