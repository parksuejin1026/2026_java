import java.util.*;

public class GradeVector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 학생 수 입력받기
        System.out.print("성적을 처리할 학생 수를 입력하세요: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        // 2. Vector 생성 (Student 객체들을 담을 가변 배열)
        // 제네릭스(<Student>)를 사용하여 Vector에 들어갈 객체 타입을 명시합니다.
        Vector<StudentGrade> students = new Vector<>(studentCount); 

        // 3. 학생 정보 입력 및 Vector에 데이터 추가
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

            // Student 객체를 생성한 후 add() 메서드를 이용해 Vector에 추가
            StudentGrade newStudent = new StudentGrade(name, kor, eng, math);
            students.add(newStudent); 
            // students.add(new Student(name, kor, eng, math)); 로 줄여 쓸 수도 있습니다.
        }

        // ---------------------------------------------------------
        // 핵심: 정렬 로직 추가 (평균 기준 내림차순)
        // ---------------------------------------------------------
        Collections.sort(students, new Comparator<StudentGrade>() {
            @Override
            public int compare(StudentGrade s1, StudentGrade s2) {
                // s2(뒤의 값)와 s1(앞의 값)을 비교하면 내림차순이 됩니다.
                return Double.compare(s2.average, s1.average);
            }
        });
        
        // 4. 결과 출력
        System.out.println("\n=======================================================");
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println("=======================================================");

        // 일반 for문을 사용하여 Vector 내 모든 학생 정보 출력
        // 배열의 length 대신 size()를, students[i] 대신 get(i)를 사용합니다.
        for (int i = 0; i < students.size(); i++) {
            students.get(i).printStudentInfo();
        }
        
        scanner.close();
    }
}