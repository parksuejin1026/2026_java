package phoneBook;

import java.util.*;
import java.io.*;

public class PhoneBookApp {
    private static Vector<Person> v = new Vector<>();
    private static Scanner sc = new Scanner(System.in);
    private static String fileName = "phonebook.txt";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.추가 2.삭제 3.검색 4.전체보기 5.저장 6.종료");
            System.out.print("선택: ");
            int menu = sc.nextInt();
            sc.nextLine(); 

            switch (menu) {
                case 1 -> addPerson();
                case 2 -> deletePerson();
                case 3 -> searchPerson();
                case 4 -> showAll();
                case 5 -> saveToFile();
                case 6 -> { System.out.println("종료합니다."); return; }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    
    private static void addPerson() {
        System.out.print("이름: "); String name = sc.nextLine();
        System.out.print("전화번호: "); String phone = sc.nextLine();
        System.out.print("이메일: "); String email = sc.nextLine();
        v.add(new Person(name, phone, email));
        System.out.println("추가 완료!");
    }

    
    private static void deletePerson() {
        System.out.print("삭제할 이름: ");
        String name = sc.nextLine();
        boolean removed = v.removeIf(p -> p.name.equals(name)); // 벡터 v를 돌면서 만약 p.name(벡터 안 요소의 이름)과 name(내가 적은 이름)이 같다면 삭제 
        System.out.println(removed ? "삭제되었습니다." : "찾을 수 없습니다.");
    }

    
    private static void searchPerson() {
        System.out.print("검색할 이름: ");
        String name = sc.nextLine();
        for (Person p : v) { // Person 객체 두는 벡터 v를 순회
            if (p.name.contains(name)) { // p.name 중 
                System.out.println(p.name + " | " + p.phone + " | " + p.email);
                return;
            }
        }
        System.out.println("검색 결과가 없습니다.");
    }

    
    private static void showAll() {
        if (v.isEmpty()) System.out.println("저장된 정보가 없습니다.");
        for (Person p : v) System.out.println(p);
    }

    
    private static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Person p : v) {
                bw.write(p.toString());
                bw.newLine();
            }
            System.out.println("파일에 저장되었습니다! (파일명: " + fileName + ")");
        } catch (IOException e) {
            System.out.println("저장 중 오류 발생: " + e.getMessage());
        }
    }
}