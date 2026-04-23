package homeAppilances;

public class SmartHome {
    public static void main(String[] args) {
        Appliance[] myHome = new Appliance[3];

        myHome[0] = new Tv("삼성");
        myHome[1] = new AirConditoner("LG");
        myHome[2] = new Tv("테슬라");

        System.out.println("=== 스마트홈 외출 모드 해제");

        for (int i = 0; i < myHome.length; i++) {
            myHome[i].powerOn();
            myHome[i].performTask();
        }

        System.out.println("연결된 가전 개수 : " + myHome.length);
    }
}
