import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyListenerEx extends JFrame {
    // 세 개의 정보를 출력할 라벨 배열 선언 (0: 코드, 1: 문자, 2: 텍스트 이름)
    private JLabel [] keyMessage; 

    public KeyListenerEx() {
        setTitle("keyListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로세스도 함께 완전히 종료
        
        Container c = getContentPane();
        // 순서대로 컴포넌트를 배치하는 FlowLayout 설정
        c.setLayout(new FlowLayout());

        // 컨텐트팬(c)에 키보드 입력을 감지할 커스텀 리스너 등록
        c.addKeyListener(new MyKeyListener());

        // 라벨 3개를 담을 배열 공간 생성 및 초기 문자열 설정
        keyMessage = new JLabel [3]; 
        keyMessage[0] = new JLabel(" getKeyCode() ");
        keyMessage[1] = new JLabel(" getKeyChar() ");
        keyMessage[2] = new JLabel(" getKeyText() ");

        // 반복문을 돌며 라벨을 화면에 추가하고 배경색 설정
        for(int i=0; i<keyMessage.length; i++) {
            c.add(keyMessage[i]); // 컨텐트팬에 라벨 부착
            
            // [클린 코드/AWT 특징]: JLabel은 기본적으로 배경이 투명합니다(False). 
            // 배경색(Background)을 보이게 하려면 반드시 불투명성(Opaque)을 true로 설정해야 합니다.
            keyMessage[i].setOpaque(true);
            keyMessage[i].setBackground(Color.YELLOW); // 노란색 배경 설정
        }
        
        setSize(300, 150); // 창 크기 설정
        setVisible(true);  // 화면에 창을 표시

        // [포커스 설정]: 키 입력을 정상적으로 받기 위해 컨텐트팬을 활성화하고 포커스를 강제 배정
        c.setFocusable(true);
        c.requestFocus();
    }

    // 키 이벤트를 처리하기 위한 내부 클래스 (KeyAdapter 활용)
    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();   // 1. 키보드의 고유 정수형 코드값(가상 키) 획득
            char keyChar = e.getKeyChar();   // 2. 입력된 유니코드 문자 값 획득

            // 첫 번째 라벨: 가상 키 코드 숫자를 문자열로 변환하여 출력 (예: Enter 키 입력 시 10)
            keyMessage[0].setText(Integer.toString(keyCode));
            
            // 두 번째 라벨: 입력된 문자 자체를 출력 (예: 'a' 입력 시 a, 문자 값이 없는 Shift 등은 깨진 네모나 공백으로 표시)
            keyMessage[1].setText(Character.toString(keyChar));
            
            // 세 번째 라벨: KeyEvent 클래스의 정적(static) 메서드를 이용해 해당 코드의 한글/영문 이름 획득 후 출력 (예: "Enter", "F1")
            keyMessage[2].setText(e.getKeyText(keyCode));
        }   
    }

    public static void main(String [] args) {
        // 프로그램 실행
        new KeyListenerEx();
    }
}