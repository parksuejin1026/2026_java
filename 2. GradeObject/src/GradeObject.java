import java.util.*;

public class GradeObject {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // 1. 학생 수 입력받기 = 배열크기
        System.out.print("성적을 처리할 학생 수를 입력하세요: ");
        int studentCount = s.nextInt();
        s.nextLine(); 

        // 2. 객체 배열 생성 (StudentGrade 객체들을 담을 공간 마련)
        StudentGrade[] students = new StudentGrade[studentCount];

        // 3. 학생 정보 입력 및 객체 생성
        for (int i = 0; i < studentCount; i++) {
            System.out.println("\n[" + (i + 1) + "번째 학생 정보 입력]");
            
            System.out.print("이름: ");
            String name = s.nextLine();

            System.out.print("국어 점수: ");
            int kor = s.nextInt();

            System.out.print("영어 점수: ");
            int eng = s.nextInt();

            System.out.print("수학 점수: ");
            int math = s.nextInt();
            s.nextLine(); // 버퍼 비우기

            // 입력받은 데이터로 Student 객체를 생성하여 배열에 저장
            students[i] = new StudentGrade(name, kor, eng, math);
        }

        // 4. 결과 출력
        System.out.println("\n=======================================================");
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println("=======================================================");

        // 일반 for문을 사용하여 배열 내 모든 학생 정보 출력
        // 인덱스(i)를 직접 제어하므로 특정 위치의 데이터에 접근하거나 순서를 조작할 때 유리합니다.
        for (int i = 0; i < studentCount; i++) {
            students[i].printStudentInfo();
        }
        
        s.close();
    }
}
