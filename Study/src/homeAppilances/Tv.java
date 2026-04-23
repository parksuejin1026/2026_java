package homeAppilances;

public class Tv extends Appliance {
    private int channel;

    public Tv(String brand) {
        super(brand);
        this.channel = 0;
    }

    @Override
    public void performTask() {
        if (isOn) {
            System.out.println(brand + " TV 채널 " + channel + "을 시청합니다.");
        } else {
            System.out.println(brand + " TV가 꺼져있습니다.");
        }
    }

    public void changeChannel(int newChannel) {
        this.channel = newChannel;
        System.out.println(brand + " 채널이 " + newChannel + "(으)로 변경되었습니다.");

    }
}
