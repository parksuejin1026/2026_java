import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class IndepClassListener extends JFrame {
	public IndepClassListener() {
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane(); // 컨테이너 만들기
		c.setLayout(new FlowLayout()); // 컨테이너의 레이아웃을 FlowLayout으로 설정
		JButton btn = new JButton("Action"); // "Action"이라는 이름을 가진 버튼 객체 생성
		btn.addActionListener(new MyActionListener()); // 버튼에 액션리스너 달기
		c.add(btn);
		
		setSize(350, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new IndepClassListener();
	}
}

class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals("Action"))
			b.setText("액션");
		else
			b.setText("Action");
	}
}

