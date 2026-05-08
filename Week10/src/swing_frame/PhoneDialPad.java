package swing_frame;

import javax.swing.*;
import java.awt.*;

public class PhoneDialPad extends JFrame {
	public PhoneDialPad() {
		setTitle("박수진의 전화");
		setSize(350, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// 1. 상단 입력창
		JTextField display = new JTextField();
		display.setPreferredSize(new Dimension(0, 40));
		add(display, BorderLayout.NORTH);
		
		// 2. 중앙 키패드 패널 (Center)
        JPanel keypadPanel = new JPanel();
        keypadPanel.setLayout(new GridLayout(4, 3, 2, 2)); // 4행 3열의 격자 레이아웃

        String[] buttons = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "*", "0", "#"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            keypadPanel.add(btn);
        }
        add(keypadPanel, BorderLayout.CENTER);

        // 3. 하단 메뉴 패널 (South)
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10)); // 수평 간격 조절

        menuPanel.add(new JLabel("키패드"));
        menuPanel.add(new JLabel("최근기록"));
        menuPanel.add(new JLabel("연락처"));

        add(menuPanel, BorderLayout.SOUTH);

        setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PhoneDialPad();
	}

}
