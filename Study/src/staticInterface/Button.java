package staticInterface;

public class Button {
    // 정적 멤버 인터페이스
    public static interface ClickListener {
        void onClick();
    }

    // 필드
    private ClickListener clickListener; // 클릭리스너를 타입으로 가지는 변수 생성

    // 메서드
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void click() {
        this.clickListener.onClick();
    }
}
