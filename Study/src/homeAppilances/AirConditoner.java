package homeAppilances;

public class AirConditoner extends Appliance {
    private int temp;

    public AirConditoner(String brand) {
        super(brand);
        this.temp = 24; // 기본온도
    }

    @Override
    public void performTask() {
        if (isOn) {
            System.out.println(brand + "에어컨이" + temp + "도로 냉방 중입니다.");
        }
    }
}
