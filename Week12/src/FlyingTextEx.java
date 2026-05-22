import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FlyingTextEx extends JFrame {
    // 텍스트가 한 번에 이동할 거리 (픽셀 단위 크기)
    private final int FLYING_UNIT = 10; 
    // 화면에서 움직이게 될 라벨 컴포넌트 생성
    private JLabel la = new JLabel("Hello"); 

    public FlyingTextEx() {
        setTitle("상, 하, 좌, 우 키를 이용하여 텍스트 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로그램도 함께 종료
        
        Container c = getContentPane();
        c.setLayout(null); // 배치관리자를 삭제하여 원하는 절대 좌표(x, y)에 컴포넌트를 직접 배치할 수 있게 함
        
        // 컨텐트팬(c)에 키 이벤트를 감지할 리스너(MyKeyListener)를 등록
        c.addKeyListener(new MyKeyListener());

        // "Hello" 라벨의 초기 위치와 크기 설정 (x: 50, y: 50 위치에 가로 100, 세로 200 크기)
        la.setLocation(50, 50);
        la.setSize(100, 200);
        c.add(la); // 컨텐트팬에 라벨 추가
        
        setSize(300, 300); // 윈도우 창 크기를 300x300으로 설정
        setVisible(true);  // 창이 화면에 보이도록 설정
        
        // 키 입력을 받기 위해 컨텐트팬이 포커스(Focus)를 가질 수 있도록 설정하고 포커스를 강제로 가져옴
        c.setFocusable(true);
        c.requestFocus();
        
        // 사용자가 마우스로 화면(컨텐트팬)을 클릭했을 때 다시 키 입력 포커스를 뺏어오는 리스너
        // 다른 컴포넌트 때문에 포커스를 잃어 키보드가 안 먹히는 현상을 방지함
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component com = (Component)e.getSource(); // 클릭된 대상(여기서는 컨텐트팬)을 가져옴
                com.setFocusable(true);
                com.requestFocus(); // 해당 컴포넌트에 다시 포커스 부여
            }
        });
    }
    
    // 키보드 입력을 처리하기 위한 내부 클래스 (KeyAdapter 상속)
    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode(); // 사용자가 누른 키의 고유 코드 값을 가져옴
            
            // 누른 키의 종류(방향키)에 따라 라벨의 x, y 좌표를 변경
            switch(keyCode) {
                case KeyEvent.VK_UP:    // 위쪽 방향키
                    // y 좌표를 감소시켜 위로 이동 (모니터 좌표계는 위로 갈수록 y가 작아짐)
                    la.setLocation(la.getX(), la.getY() - FLYING_UNIT);
                    break;
                case KeyEvent.VK_DOWN:  // 아래쪽 방향키
                    // y 좌표를 증가시켜 아래로 이동
                    la.setLocation(la.getX(), la.getY() + FLYING_UNIT); 
                    break;
                case KeyEvent.VK_LEFT:  // 왼쪽 방향키
                    // x 좌표를 감소시켜 왼쪽으로 이동
                    la.setLocation(la.getX() - FLYING_UNIT, la.getY()); 
                    break;
                case KeyEvent.VK_RIGHT: // 오른쪽 방향키
                    // x 좌표를 증가시켜 오른쪽으로 이동
                    la.setLocation(la.getX() + FLYING_UNIT, la.getY()); 
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        // 프로그램 시작점: 메인 윈도우 객체 생성
        new FlyingTextEx();
    }
}