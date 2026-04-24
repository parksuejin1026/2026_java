# 🧪 객체지향 프로그래밍 오픈북 시험 치트시트 (Java)
> **목적**: 시험장에서 "완전한 프로그램"을 빠르게 만들기 위한 복붙용 템플릿 모음  
> **범위**: Week 2 ~ Week 7 (기본 문법 · OOP · Collection · Thread · File I/O · Stream)

---

## 📑 목차

1. [프로그램 뼈대](#1-프로그램-뼈대)
2. [입력 받기 (Scanner)](#2-입력-받기-scanner)
3. [난수 (Random)](#3-난수-random)
4. [출력 포맷팅](#4-출력-포맷팅)
5. [제어문](#5-제어문)
6. [배열 (1D / 2D)](#6-배열)
7. [클래스 · 생성자 · 캡슐화](#7-클래스-생성자-캡슐화)
8. [상속 · super · 오버라이딩](#8-상속--super--오버라이딩)
9. [추상 클래스 · 인터페이스](#9-추상-클래스--인터페이스)
10. [Collection - Vector / ArrayList](#10-collection---vector--arraylist)
11. [Collection - HashMap](#11-collection---hashmap)
12. [Collections 정렬 · Comparator](#12-collections-정렬--comparator)
13. [Stream API](#13-stream-api)
14. [Thread 기본](#14-thread-기본)
15. [Runnable 방식 (권장)](#15-runnable-방식-권장)
16. [Thread 동기화 (synchronized)](#16-thread-동기화-synchronized)
17. [File I/O - 읽기](#17-file-io---읽기)
18. [File I/O - 쓰기](#18-file-io---쓰기)
19. [예외 처리](#19-예외-처리)
20. [🎯 완성 프로그램 템플릿 (좀비 게임)](#20-완성-프로그램-템플릿-좀비-게임)
21. [🎯 완성 프로그램 템플릿 (성적 관리)](#21-완성-프로그램-템플릿-성적-관리)
22. [자주 쓰는 조합 패턴 모음](#22-자주-쓰는-조합-패턴-모음)

---

## 1. 프로그램 뼈대

```java
package week;  // 필요시

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 여기에 코드
        sc.close();
    }
}
```

---

## 2. 입력 받기 (Scanner)

```java
Scanner sc = new Scanner(System.in);

int n       = sc.nextInt();        // 정수
double d    = sc.nextDouble();     // 실수
float f     = sc.nextFloat();      // float
String word = sc.next();           // 공백 전까지 한 단어
sc.nextLine();                     // ⚠️ 버퍼 비우기 (nextInt 뒤에 필수)
String line = sc.nextLine();       // 한 줄 전체

sc.close();
```

### 🚨 버퍼 꼬임 방지 패턴
```java
int n = sc.nextInt();
sc.nextLine();              // ← 이거 없으면 다음 nextLine()이 빈 문자열 먹음
String name = sc.nextLine();
```

### 입력 분리하기
```java
String input = sc.nextLine();      // "홍길동 010-1234 email@a.com"
String[] data = input.split(" ");  // 공백 기준 분리
String name = data[0];
String phone = data[1];
```

---

## 3. 난수 (Random)

```java
import java.util.Random;

Random random = new Random();

int n = random.nextInt(6);       // 0 ~ 5
int dice = random.nextInt(6) + 1;// 1 ~ 6
int r = random.nextInt(3) + 1;   // 1 ~ 3
float p = random.nextFloat();    // 0.0 ~ 1.0

// 20% 확률 판정
if (random.nextFloat() > 0.8) { /* 20% 확률 */ }

// -1 또는 +1 (방향 랜덤)
int sign = random.nextInt(2) * 2 - 1;
```

---

## 4. 출력 포맷팅

```java
System.out.println("값: " + x);
System.out.print("개행 없음");

// printf: %d 정수, %f 실수, %s 문자열, \t 탭, \n 개행
System.out.printf("%s\t%d\t%.2f\n", name, score, average);
// %.2f : 소수점 2자리
// %5d  : 5칸 정수(오른쪽 정렬)
// %-5s : 5칸 문자열(왼쪽 정렬)
```

---

## 5. 제어문

### if / else if / else
```java
if (x > 0) { ... }
else if (x == 0) { ... }
else { ... }
```

### switch
```java
switch (command) {
    case 1:
        // ...
        break;
    case 2:
        // ...
        break;
    default:
        // ...
        break;
}
```

### while / do-while / for
```java
while (true) { 
    if (조건) break;
    if (스킵조건) continue;
}

for (int i = 0; i < n; i++) { ... }

// 향상된 for (배열/Collection 순회)
for (int x : arr) { ... }
for (Zombie z : zombies) { ... }
```

---

## 6. 배열

### 1차원 배열
```java
int[] arr = new int[5];                 // 0으로 초기화
int[] arr2 = {1, 2, 3, 4, 5};           // 직접 초기화
String[] names = new String[3];

arr.length;                             // 크기
```

### 2차원 배열
```java
int[][] map = new int[5][5];
int[][] map2 = {
    {0, 0, 1, 1, 1},
    {1, 0, 0, 1, 1},
    {1, 1, 0, 0, 1}
};

map.length;       // 행 수
map[0].length;    // 열 수

for (int i = 0; i < map.length; i++) {
    for (int j = 0; j < map[i].length; j++) {
        System.out.print(map[i][j] + " ");
    }
    System.out.println();
}
```

### 객체 배열
```java
StudentGrade[] students = new StudentGrade[n];
for (int i = 0; i < n; i++) {
    students[i] = new StudentGrade(...);
}
```

---

## 7. 클래스 · 생성자 · 캡슐화

```java
public class Student {
    // 필드 (private 권장 = 캡슐화)
    private String name;
    private int score;

    // 생성자
    public Student(String name, int score) {
        this.name = name;       // this: 현재 객체
        this.score = score;
    }

    // getter / setter
    public String getName() { return name; }
    public void setScore(int score) { this.score = score; }

    // 메서드
    public void print() {
        System.out.println(name + ": " + score);
    }
}
```

### 사용
```java
Student s = new Student("홍길동", 90);
s.print();
System.out.println(s.getName());
```

### static 필드/메서드
```java
public class Config {
    static final int MAP_MAX = 20;      // 상수
    static int count = 0;               // 클래스 변수(모든 객체 공유)

    static void show() { ... }          // 객체 없이 Config.show() 호출 가능
}
```

---

## 8. 상속 · super · 오버라이딩

```java
// 부모
public class Character {
    String name;
    int health;
    int atk;

    public Character(String name, int health, int atk) {
        this.name = name;
        this.health = health;
        this.atk = atk;
    }

    public void attack(Character enemy) {
        enemy.health -= this.atk;
    }
}

// 자식
public class Boss extends Character {
    public Boss(String name, int health, int atk) {
        super(name, health, atk);       // 부모 생성자 호출 (첫 줄 필수)
    }

    @Override
    public void attack(Character enemy) {  // 오버라이딩
        int dmg = this.atk * 2;
        enemy.health -= dmg;
    }

    // 자식만의 새 메서드
    public void ultimate(Character enemy) {
        enemy.health -= this.atk * 3;
    }
}
```

### 다형성
```java
Character c = new Boss("마왕", 300, 20);  // 부모 타입이 자식 객체 참조
c.attack(player);                          // Boss의 attack() 실행 (동적 바인딩)
```

---

## 9. 추상 클래스 · 인터페이스

### 추상 클래스 (공통 필드 + 일부 구현 + 강제 구현)
```java
public abstract class Unit {
    String name;
    int pos;

    public Unit(String name, int pos) {
        this.name = name;
        this.pos = pos;
    }

    // 공통 구현
    public void left()  { if (pos > 1) pos--; }
    public void right() { if (pos < 20) pos++; }

    // 자식이 반드시 구현해야 함
    public abstract void move();
}

// 자식 1
public class Hero extends Unit {
    public Hero(String name, int pos) { super(name, pos); }

    @Override
    public void move() { /* 사용자 입력 기반 */ }
}

// 자식 2
public class Zombie extends Unit {
    public Zombie(String name, int pos) { super(name, pos); }

    @Override
    public void move() { /* 랜덤 */ }
}
```

### 인터페이스
```java
public interface Movable {
    void move();                         // public abstract 생략됨
    default void stop() { ... }          // Java 8+ 기본 구현
}

public class Car implements Movable {
    @Override
    public void move() { ... }
}

// 다중 구현 가능
public class Zombie extends Unit implements Runnable {
    @Override public void move() { ... }
    @Override public void run() { ... }
}
```

---

## 10. Collection - Vector / ArrayList

```java
import java.util.*;

Vector<Integer> v = new Vector<>();
ArrayList<String> list = new ArrayList<>();

// 추가
v.add(10);               // 끝에 추가
v.add(2, 99);            // 2번 인덱스에 삽입 (기존 요소는 밀림)

// 조회
int x = v.get(0);
int size = v.size();

// 삭제
v.remove(1);             // 인덱스로 삭제
v.remove(Integer.valueOf(10));  // 값으로 삭제

// 포함 여부
boolean has = v.contains(10);

// 순회
for (int i = 0; i < v.size(); i++) {
    System.out.println(v.get(i));
}
for (int n : v) { System.out.println(n); }
```

### 객체 Vector
```java
Vector<Student> students = new Vector<>();
students.add(new Student("홍길동", 90));

for (Student s : students) { s.print(); }
```

---

## 11. Collection - HashMap

```java
HashMap<String, Student> map = new HashMap<>();

// 추가/수정
map.put("홍길동", new Student("홍길동", 90));

// 조회
Student s = map.get("홍길동");              // 없으면 null
Student s2 = map.getOrDefault("없음", null);

// 존재 확인
if (map.containsKey("홍길동")) { ... }
if (map.get("홍길동") != null)   { ... }

// 삭제
map.remove("홍길동");

// 크기
int size = map.size();

// 순회
for (String key : map.keySet())          { ... }
for (Student v : map.values())           { ... }
for (Map.Entry<String, Student> e : map.entrySet()) {
    String k = e.getKey();
    Student v = e.getValue();
}
```

---

## 12. Collections 정렬 · Comparator

### 기본 정렬 (Comparable 필요)
```java
Collections.sort(list);       // 오름차순
Collections.sort(list, Collections.reverseOrder());  // 내림차순
```

### Comparator - 익명 클래스 (제출 코드 스타일)
```java
Collections.sort(students, new Comparator<StudentGrade>() {
    @Override
    public int compare(StudentGrade a, StudentGrade b) {
        return Double.compare(b.average, a.average);  // b가 앞 → 내림차순
    }
});
```

### Comparator - 람다 (더 짧음)
```java
students.sort((a, b) -> Double.compare(b.average, a.average));       // 내림차순
students.sort((a, b) -> a.name.compareTo(b.name));                   // 이름 오름차순
students.sort(Comparator.comparingDouble((StudentGrade s) -> s.average).reversed());
```

### 비교 규칙 (외우기)
- `return 음수` → a가 앞
- `return 양수` → b가 앞
- `return 0`   → 동일

---

## 13. Stream API

```java
import java.util.stream.*;

List<Student> students = ...;

// 필터링
students.stream()
        .filter(s -> s.average >= 80)
        .forEach(s -> System.out.println(s.name));

// 매핑 (변환)
List<String> names = students.stream()
        .map(s -> s.name)
        .collect(Collectors.toList());

// 정렬 + 상위 N개
students.stream()
        .sorted((a, b) -> Double.compare(b.average, a.average))
        .limit(3)
        .forEach(s -> s.printStudentInfo());

// 집계
long count = students.stream().filter(s -> s.average >= 80).count();
double avg = students.stream().mapToDouble(s -> s.average).average().orElse(0);
int sum    = students.stream().mapToInt(s -> s.kor).sum();

// 조건 검사 (bool 반환)
boolean anyHigh = students.stream().anyMatch(s -> s.average >= 90);
boolean allPass = students.stream().allMatch(s -> s.average >= 60);
boolean noneFail= students.stream().noneMatch(s -> s.average < 60);
```

### 제출 코드에서의 실전 사용 (좀비 충돌 검사)
```java
if (zombies.values().stream().anyMatch(z -> z.pos == hero.pos)) {
    System.out.println("좀비에게 잡혔습니다");
}
```

---

## 14. Thread 기본

### 방법 1: Thread 상속
```java
class MyThread extends Thread {
    public MyThread(String name) { super(name); }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + ": " + i);
            try { Thread.sleep(500); } 
            catch (InterruptedException e) { return; }
        }
    }
}

// 사용
MyThread t = new MyThread("스레드1");
t.start();                // ⚠️ run()이 아니라 start() !!
```

### 주요 메서드
```java
t.start();                              // 스레드 시작
t.getName();                            // 이름
t.setName("이름");
Thread.sleep(1000);                     // 1초 멈춤 (throws InterruptedException)
Thread.currentThread();                 // 현재 스레드
Thread.activeCount();                   // 활성 스레드 수
t.interrupt();                          // 중단 요청
t.join();                               // 이 스레드 끝날 때까지 대기
```

---

## 15. Runnable 방식 (권장)

```java
class ZombieTask implements Runnable {
    private final String name;
    private final Hero hero;

    public ZombieTask(String name, Hero hero) {
        this.name = name;
        this.hero = hero;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            while (true) {
                Thread.sleep((r.nextInt(3) + 1) * 1000);
                System.out.println(name + " 움직임");

                if (hero.pos == /* 내 위치 */ 5) {
                    System.out.println("잡았다!");
                }
            }
        } catch (InterruptedException e) {
            return;          // 중단 신호 받으면 깔끔히 종료
        }
    }
}

// 사용
Thread t1 = new Thread(new ZombieTask("좀비1", hero));
Thread t2 = new Thread(new ZombieTask("좀비2", hero));
t1.start();
t2.start();

// 종료
t1.interrupt();
t2.interrupt();
```

### 람다로 더 짧게
```java
Thread t = new Thread(() -> {
    for (int i = 0; i < 5; i++) System.out.println("tick " + i);
});
t.start();
```

### Unit 추상클래스 + Runnable 조합 (제출 코드 패턴)
```java
public class Zombie extends Unit implements Runnable {
    private final Hero hero;

    public Zombie(String name, int pos, Hero hero) {
        super(name, pos);
        this.hero = hero;
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.move();
                Thread.sleep(1000);
                if (hero.pos == this.pos) hero.pos = 1;
            }
        } catch (InterruptedException e) { return; }
    }

    @Override
    public void move() { /* ... */ }
}
```

---

## 16. Thread 동기화 (synchronized)

### 메서드 단위
```java
class BankAccount {
    int balance = 0;

    public synchronized void deposit(int money) {   // 한 번에 한 스레드만
        balance += money;
    }

    public synchronized void withdraw(int money) {
        if (balance >= money) balance -= money;
    }
}
```

### 블록 단위 (더 세밀한 제어)
```java
Object lock = new Object();

public void update() {
    synchronized (lock) {
        // 임계구역
    }
}
```

### 왜 필요한가
- 여러 스레드가 같은 변수에 동시 접근 → race condition
- `balance -= money`는 "읽기→계산→쓰기" 3단계라 중간에 끼어들면 값이 꼬임

---

## 17. File I/O - 읽기

### 한 줄씩 읽기 (BufferedReader)
```java
import java.io.*;

File file = new File("./data.txt");

try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
        String[] data = line.split(" ");
        // 파싱
        String name  = data[0];
        int score    = Integer.parseInt(data[1]);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### 파일 존재 확인
```java
File file = new File("./save.txt");
if (file.exists()) {
    // 읽기
}
```

---

## 18. File I/O - 쓰기

### 덮어쓰기
```java
try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
    bw.write("한 줄 쓰기\n");
    for (Student s : students) {
        bw.write(s.name + " " + s.score + "\n");
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### 이어쓰기 (append)
```java
new BufferedWriter(new FileWriter(file, true))   // true = append
```

### 파일 없으면 생성
```java
if (!file.exists()) {
    file.createNewFile();    // throws IOException
}
```

### try-with-resources (권장)
- 괄호 안에서 선언된 자원은 자동으로 `close()` 호출됨
- `close()` 안 써도 됨, 예외 나도 안전

---

## 19. 예외 처리

```java
try {
    // 위험 코드
    int n = Integer.parseInt(str);
    int[] arr = new int[5];
    arr[10] = 1;
} catch (NumberFormatException e) {
    System.out.println("숫자 변환 실패");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("배열 범위 초과");
} catch (Exception e) {        // 나머지 전부
    e.printStackTrace();
} finally {
    // 무조건 실행
}
```

### throws 선언
```java
public void load() throws IOException {
    // 호출한 쪽에서 처리
}
```

### 자주 마주치는 Checked 예외 (catch 필수)
- `IOException` - 파일 I/O
- `InterruptedException` - `Thread.sleep()`
- `FileNotFoundException`

---

## 20. 🎯 완성 프로그램 템플릿 (좀비 게임)

> **포함 개념**: 추상클래스, 상속, 다형성, Collection(HashMap), Thread, File I/O, 예외처리

### Unit.java (추상 클래스)
```java
public abstract class Unit {
    protected String name;
    protected int pos;
    protected int maxPos;

    public Unit(String name, int pos, int maxPos) {
        this.name = name;
        this.pos = pos;
        this.maxPos = maxPos;
    }

    public void left()  { if (pos > 1) pos--; }
    public void right() { if (pos < maxPos) pos++; }

    public abstract void move();

    public String getName() { return name; }
    public int getPos() { return pos; }
    public void setPos(int pos) { this.pos = pos; }
}
```

### Hero.java
```java
import java.util.*;

public class Hero extends Unit {
    private int hp;
    private final Scanner sc = new Scanner(System.in);

    public Hero(String name, int pos, int hp) {
        super(name, pos, 20);
        this.hp = hp;
    }

    @Override
    public void move() {
        System.out.print("(1)왼쪽 (2)오른쪽 (3)점프: ");
        int cmd = sc.nextInt();
        switch (cmd) {
            case 1: left();  break;
            case 2: right(); break;
            case 3:
                int jump = new Random().nextInt(3) + 1;
                pos = Math.min(pos + jump, maxPos);
                break;
            default: System.out.println("잘못된 입력");
        }
    }

    public int getHp() { return hp; }
    public void damage() { hp--; }
}
```

### Zombie.java (Runnable)
```java
import java.util.Random;

public class Zombie extends Unit implements Runnable {
    private final Hero hero;

    public Zombie(String name, int pos, Hero hero) {
        super(name, pos, 20);
        this.hero = hero;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            while (true) {
                Thread.sleep((r.nextInt(2) + 1) * 1000);
                move();
                System.out.println(name + " 위치: " + pos);
            }
        } catch (InterruptedException e) { return; }
    }

    @Override
    public void move() {
        if (new Random().nextInt(2) == 0) left(); else right();
    }
}
```

### Game.java (메인)
```java
import java.io.*;
import java.util.*;

public class Game {
    public static void main(String[] args) {
        HashMap<String, Zombie> zombies = new HashMap<>();
        Hero hero = loadOrCreate(zombies);

        // 좀비 스레드 시작
        List<Thread> threads = new ArrayList<>();
        for (Zombie z : zombies.values()) {
            Thread t = new Thread(z);
            t.start();
            threads.add(t);
        }

        while (true) {
            hero.move();

            // Stream으로 충돌 검사
            boolean caught = zombies.values().stream()
                    .anyMatch(z -> z.getPos() == hero.getPos());
            if (caught) {
                hero.damage();
                hero.setPos(1);
                System.out.println("잡혔다! HP: " + hero.getHp());
                if (hero.getHp() <= 0) {
                    System.out.println("게임 오버");
                    break;
                }
            }

            if (hero.getPos() == 20) {
                System.out.println("클리어!");
                break;
            }

            save(hero, zombies);
        }

        // 좀비 스레드 정리
        for (Thread t : threads) t.interrupt();
    }

    // 파일에서 불러오기
    private static Hero loadOrCreate(HashMap<String, Zombie> zombies) {
        File file = new File("./save.txt");
        Hero hero = null;

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] d = line.split(" ");
                    if (d[0].equals("Hero")) {
                        hero = new Hero(d[1], Integer.parseInt(d[2]), Integer.parseInt(d[3]));
                    } else {
                        // 생성 시 hero 필요하므로 나중에 처리 - 간단화 위해 생략
                    }
                }
            } catch (IOException e) { e.printStackTrace(); }
        }

        if (hero == null) hero = new Hero("Hero", 1, 3);
        if (zombies.isEmpty()) {
            zombies.put("Z1", new Zombie("Z1", 7, hero));
            zombies.put("Z2", new Zombie("Z2", 15, hero));
        }
        return hero;
    }

    // 파일에 저장
    private static void save(Hero hero, HashMap<String, Zombie> zombies) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./save.txt"))) {
            bw.write("Hero " + hero.getName() + " " + hero.getPos() + " " + hero.getHp() + "\n");
            for (Zombie z : zombies.values()) {
                bw.write(z.getName() + " " + z.getPos() + "\n");
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
```

---

## 21. 🎯 완성 프로그램 템플릿 (성적 관리)

> **포함 개념**: 클래스, Vector/HashMap, Comparator, Stream, File I/O

### Student.java
```java
public class Student {
    String name;
    int kor, eng, math, total;
    double average;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.total = kor + eng + math;
        this.average = total / 3.0;
    }

    public void print() {
        System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\n",
                name, kor, eng, math, total, average);
    }

    public String toLine() {
        return name + " " + kor + " " + eng + " " + math;
    }
}
```

### Main.java
```java
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static final String FILE = "./students.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Student> map = new HashMap<>();

        load(map);   // 시작 시 파일 로드

        while (true) {
            System.out.println("\n1.추가 2.삭제 3.검색 4.전체출력 5.정렬출력 6.평균80이상 7.저장 8.종료");
            int cmd = sc.nextInt();
            sc.nextLine();

            if (cmd == 1) {
                System.out.print("이름 국어 영어 수학: ");
                String[] d = sc.nextLine().split(" ");
                Student s = new Student(d[0],
                        Integer.parseInt(d[1]),
                        Integer.parseInt(d[2]),
                        Integer.parseInt(d[3]));
                map.put(s.name, s);
            }
            else if (cmd == 2) {
                System.out.print("삭제할 이름: ");
                map.remove(sc.nextLine());
            }
            else if (cmd == 3) {
                System.out.print("검색할 이름: ");
                Student s = map.get(sc.nextLine());
                if (s != null) s.print();
                else System.out.println("없음");
            }
            else if (cmd == 4) {
                printHeader();
                for (Student s : map.values()) s.print();
            }
            else if (cmd == 5) {
                // Stream + Comparator: 평균 내림차순
                printHeader();
                map.values().stream()
                   .sorted((a, b) -> Double.compare(b.average, a.average))
                   .forEach(Student::print);
            }
            else if (cmd == 6) {
                // Stream filter
                printHeader();
                map.values().stream()
                   .filter(s -> s.average >= 80)
                   .forEach(Student::print);
            }
            else if (cmd == 7) {
                save(map);
            }
            else if (cmd == 8) break;
        }
        sc.close();
    }

    static void printHeader() {
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
    }

    static void load(HashMap<String, Student> map) {
        File f = new File(FILE);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(" ");
                Student s = new Student(d[0],
                        Integer.parseInt(d[1]),
                        Integer.parseInt(d[2]),
                        Integer.parseInt(d[3]));
                map.put(s.name, s);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    static void save(HashMap<String, Student> map) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (Student s : map.values()) {
                bw.write(s.toLine() + "\n");
            }
            System.out.println("저장 완료");
        } catch (IOException e) { e.printStackTrace(); }
    }
}
```

---

## 22. 자주 쓰는 조합 패턴 모음

### ✅ 패턴 A: 입력 루프 + switch
```java
while (true) {
    System.out.print("메뉴: ");
    int cmd = sc.nextInt();
    switch (cmd) {
        case 1: /*...*/ break;
        case 2: /*...*/ break;
        case 0: return;
        default: System.out.println("?");
    }
}
```

### ✅ 패턴 B: 맵 경계 체크 후 이동
```java
if (pos + move >= MAP_MIN && pos + move <= MAP_MAX) {
    pos += move;
}
```

### ✅ 패턴 C: 충돌 판정 (Stream)
```java
boolean hit = enemies.stream().anyMatch(e -> e.pos == player.pos);
```

### ✅ 패턴 D: 저장 파일 있으면 이어하기
```java
File f = new File("./save.txt");
if (f.exists()) {
    // 로드
} else {
    // 새 게임 초기화
}
```

### ✅ 패턴 E: 여러 좀비 스레드 관리
```java
List<Thread> threads = new ArrayList<>();
for (Zombie z : zombies) {
    Thread t = new Thread(z);
    t.start();
    threads.add(t);
}
// 종료 시
threads.forEach(Thread::interrupt);
```

### ✅ 패턴 F: HashMap 전체 출력
```java
for (Student s : map.values()) s.print();
// 또는
map.values().forEach(Student::print);
```

### ✅ 패턴 G: 정렬 후 상위 N개
```java
list.stream()
    .sorted((a, b) -> Double.compare(b.score, a.score))
    .limit(3)
    .forEach(s -> s.print());
```

### ✅ 패턴 H: 문자열 파싱
```java
String line = "홍길동 90 85 95";
String[] d = line.split(" ");
String name = d[0];
int kor = Integer.parseInt(d[1]);
```

---

## ⚠️ 시험장 실수 방지 체크리스트

| 실수 | 해결 |
|---|---|
| `nextInt()` 후 `nextLine()`이 빈 문자열 | 사이에 `sc.nextLine();` 한 줄 넣기 |
| Thread가 동작 안 함 | `run()`이 아니라 `start()` 호출 |
| `Thread.sleep` 컴파일 에러 | try-catch로 `InterruptedException` 처리 |
| 파일 I/O 컴파일 에러 | try-catch로 `IOException` 처리 |
| 자식 생성자 에러 | `super(...)`를 **첫 줄**에 작성 |
| 추상 클래스로 `new` 불가 | 자식 클래스로 인스턴스화 |
| HashMap 순서 보장 안 됨 | 순서 필요하면 `LinkedHashMap` |
| Scanner 두 번 close 하면 에러 | 한 곳에서만 close (또는 필드로 관리) |
| 배열 인덱스 초과 | `arr.length`로 경계 체크 |
| `==` vs `equals` | 문자열 비교는 무조건 `.equals()` |

---

## 📦 import 치트시트 (복붙용)

```java
import java.util.Scanner;
import java.util.Random;
import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
```

### 한 방에 import (게으른 버전)
```java
import java.util.*;
import java.io.*;
import java.util.stream.*;
```

---

**시험 잘 보세요! 🍀**
