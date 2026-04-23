package staticInterface;

public class ButtonEx {
    public static void main(String[] args) {
        // OK 버튼 객체 생성
        Button btnOk = new Button();

        // OK 버튼 클릭 이벤트를 처리할 클릭리스너 구현 클래스 (로컬 클래스)
        class OkListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("OK 버튼을 클릭하였습니다.");
            }
        }

        // OK 버튼 객체에 클릭리스너 구현 객체 주입
        btnOk.setClickListener(new OkListener());

        // OK 버튼 클릭
        btnOk.click(); // onClick 실행됨
    }
}
