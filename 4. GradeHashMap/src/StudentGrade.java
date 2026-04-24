// 학생 정보를 담고 성적을 계산하는 클래스
class StudentGrade {
    // 캡슐화를 위해 필드는 private으로 선언
    String name;
    int kor;
    int eng;
    int math;
    int total;
    double average;

    // 생성자: 객체를 생성할 때 이름과 점수를 초기화하고, 총점과 평균을 바로 계산
    public StudentGrade(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        calculateGrade(); // 생성 시 자동으로 계산 로직 호출
    }

    // 총점과 평균을 계산하는 메서드
    private void calculateGrade() {
        this.total = this.kor + this.eng + this.math;
        this.average = this.total / 3.0;
    }

    // 학생 정보를 포맷에 맞춰 출력하는 메서드
    public void printStudentInfo() {
        System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\n", 
                this.name, this.kor, this.eng, this.math, this.total, this.average);
    }
}