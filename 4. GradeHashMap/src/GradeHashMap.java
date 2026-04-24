import java.util.*;

public class GradeHashMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. HashMap 생성
        // Key: String (학생 이름), Value: Student (해당 학생의 정보 객체)
        HashMap<String, StudentGrade> studentMap = new HashMap<>();

        System.out.print("성적을 입력할 학생 수를 입력하세요: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        // 2. 학생 정보 입력 및 HashMap에 추가 (put)
        for (int i = 0; i < studentCount; i++) {
            System.out.println("\n[" + (i + 1) + "번째 학생 정보 입력]");
            
            System.out.print("이름: ");
            String name = scanner.nextLine();

            System.out.print("국어 점수: ");
            int kor = scanner.nextInt();

            System.out.print("영어 점수: ");
            int eng = scanner.nextInt();

            System.out.print("수학 점수: ");
            int math = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            // 입력받은 정보로 객체를 생성하고, 이름(name)을 Key로 사용하여 맵에 저장합니다.
            studentMap.put(name, new StudentGrade(name, kor, eng, math));
        }

        System.out.println("\n데이터 입력이 완료되었습니다. 검색 모드로 전환합니다.");

        // 3. 학생 이름 검색 및 출력 루프
     // 2. 검색 및 전체 출력 루프
        while (true) {
            System.out.print("\n검색할 학생 이름 (전체출력: '전체', 종료: '종료'): ");
            String input = scanner.nextLine();

            if (input.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } 
            // =========================================================
            // 핵심 추가 부분: HashMap 전체 데이터 출력 로직
            // =========================================================
            else if (input.equals("전체")) {
            	System.out.println("=======================================================");
                System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
                System.out.println("=======================================================");
                
                // values()를 활용하여 Value(Student 객체)만 모두 꺼내기
                for (StudentGrade student : studentMap.values()) {
                    student.printStudentInfo();
                }
                
                System.out.println("=======================================================");
            } 
            // =========================================================
            else {
                // 단일 학생 검색 로직
                StudentGrade foundStudent = studentMap.get(input);

                if (foundStudent != null) {
                	System.out.println("=======================================================");
                    System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
                    System.out.println("=======================================================");               
                	foundStudent.printStudentInfo();
                    System.out.println("=======================================================");
                } else {
                    System.out.println("등록되지 않은 학생입니다.");
                }
            }
        }
        
        scanner.close();
    }
}