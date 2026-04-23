package homeAppilances;

public class Appliance {
    protected String brand;
    protected boolean isOn;

    public Appliance(String brand) {
        this.brand = brand;
        this.isOn = false;
    }

    // 공통 기능 : 전원 켜기
    public void powerOn() {
        isOn = true;
        System.out.println(brand + " 가전의 전원을 켭니다.");
    }

    // 추상적인 기능 (자식이 구현할 부분)
    public void performTask() {
        System.out.println("가전제품이 대기 중입니다.");
    }
}
