package Study;

import java.util.*;


class User1 {
    private String name;
    private String job;
    private int age;

    public User1 (String name, String job, int age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    public String getName() { return name; }
    public String getJob() { return job; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "- 사용자 이름 : " + name + " | 직업 : " + job + " | 나이 : " + age + " -";
    }
}

public class Study_11 {
    public static void main(String[] args) {
        List<User1> userList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true) { 
            System.out.println("\n[사용자 정보 입력]");
            
            System.out.print("이름: ");
            String userName = sc.next();
            
            System.out.print("직업: ");
            String userJob = sc.next();
            
            System.out.print("나이: ");
            int userAge = sc.nextInt();
            
            userList.add(new User1(userName, userJob, userAge));
            
            System.out.print("종료하려면 'q'를, 계속하려면 아무 키나 누르세요: ");
            String finish = sc.next();
            
            // 핵심 수정: 문자열 비교는 반드시 " " 사용
            if(finish.equalsIgnoreCase("q")) {
                System.out.println("입력을 종료합니다.\n");
                break;
            }
        }

        System.out.println("=== 등록된 사용자 리스트 ===");
        userList.stream().forEach(System.out::println);
        
        sc.close(); // Scanner 리소스 닫기
    }
}
