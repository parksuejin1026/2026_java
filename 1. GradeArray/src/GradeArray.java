import java.util.*;

public class GradeArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // 1. 학생 수 입력받기
        System.out.print("성적을 처리할 학생 수를 입력하세요: ");
        int studentCount = s.nextInt();
        s.nextLine(); // 버퍼에 남은 줄바꿈 문자 제거

        // 2. 배열 생성
        String[] names = new String[studentCount]; // 학생 이름을 저장할 1차원 배열
        int[][] scores = new int[studentCount][4]; // [학생수][국, 영, 수, 총점]을 저장할 2차원 배열
        double[] averages = new double[studentCount]; // 평균을 저장할 1차원 배열

        // 3. 학생 정보 및 성적 입력받기
        for (int i = 0; i < studentCount; i++) {
            System.out.println("\n[" + (i + 1) + "번째 학생 정보 입력]");
            
            System.out.print("이름: ");
            names[i] = s.nextLine();

            System.out.print("국어 점수: ");
            scores[i][0] = s.nextInt();

            System.out.print("영어 점수: ");
            scores[i][1] = s.nextInt();

            System.out.print("수학 점수: ");
            scores[i][2] = s.nextInt();
            s.nextLine(); // 버퍼 비우기

            // 총점 및 평균 계산
            scores[i][3] = scores[i][0] + scores[i][1] + scores[i][2]; // 총점
            averages[i] = scores[i][3] / 3.0; // 평균 (실수형 결과를 위해 3.0으로 나눔)
        }

        // 4. 결과 출력
        System.out.println("\n=======================================================");
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println("=======================================================");

        for (int i = 0; i < studentCount; i++) {
            // printf를 사용하여 간격과 소수점 자릿수(평균)를 맞추어 출력
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\n", 
                    names[i], scores[i][0], scores[i][1], scores[i][2], scores[i][3], averages[i]);
        }
        
        s.close();
    }
}